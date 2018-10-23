# Backend Service

#####install services using make file

```json
make
```

#####backend service:

```json
- kubectl apply -f backend-service.yaml
```

This contains three endpoints demonstrating the three levels of access:-

```java

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello User!";
    }

    @GetMapping("/guest")
    public String guest() {
        return "Hello Guest!";
    }
    
```