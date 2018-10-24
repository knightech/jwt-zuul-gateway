### local k8s cluster

Give 'Spring Cloud Kubernetes' access to Kubernetes API:
```
kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default
```

Running this command creates the nginx ingress controller that works with docker for mac:

```
 kubectl apply -f nginx-ingress/namespaces/nginx-ingress.yaml -Rf nginx-ingress

```