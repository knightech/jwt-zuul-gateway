### jwt-zuul-gateway

##### **auth-center**
The service to issue the `JWT` token.
- The client POST `{username,password}` to `/login`.
- This service will authenticate the username and password via `Spring Security`,
  generate the token, and issue it to client in a header value.

##### **user-service**
The service that registers new users which creates a default Admin user on startup (using in-memory mongo)

```java
curl -i -H "Content-Type: application/json" -X POST -d '{"email":"admin@knightech.net","password":"password"}' http://localhost:8080/login
```

now register new user:
```json

curl -X POST   http://localhost:8080/user/register   -H 'authorization: Bearer <<<token for admin>>>'   -H 'content-type: application/json'   -d '{"email":"banana@knightech.net","password":"password","roles":[{"role":"USER"}]}'
```

Login with user with only USER role and you don't get access to backend/admin

##### 2. **backend-service**
The three simple services:
- `/admin`
- `/user`
- `/guest`
 
##### 3. **api-gateway**
The `Zuul` gateway:
- Define `Zuul` routes to `auth-center` and `backend-service`.
- Verify `JWT` token.
- Define role-based auth via `Spring Security`:
    - `/login` is public to all.
    - `/user/register` can only be accessed by role `ADMIN`.
    - `/backend/admin` can only be accessed by role `ADMIN`.
    - `/backend/user` can only be accessed by role `USER`.
    - `/backend/guest` is public to all.

No token 401
No access 403
```json
curl -X GET   http://localhost:8080/backend/admin   -H 'authorization: Bearer <<<token for admin>>>'   -H 'content-type: application/json'
```
Access 200!
```
curl -X GET   http://localhost:8080/backend/admin   -H 'authorization: Bearer <<<token for user>>>'   -H 'content-type: application/json'
```

