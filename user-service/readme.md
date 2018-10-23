##User Service

#####install services using make file

```json
make
```

#####mongo database:

```json
- kubectl apply -f kubernetes/mongodb-configmap.yaml
- kubectl apply -f kubernetes/mongodb-secret.yaml
- kubectl apply -f kubernetes/mongodb-deployment.yaml
```

#####user service:

```json
- kubectl apply -f user-service.yaml
