### local k8s cluster

Give 'Spring Cloud Kubernetes' access to Kubernetes API:
```
kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default
```

Running this command creates the nginx ingress controller that works with docker for mac:

```
 kubectl apply -f nginx-ingress/namespaces/nginx-ingress.yaml -Rf nginx-ingress

```

Finally, executing "make" creates all the api services, the gateway (swagger) and the ingress: 

```
make 
```

The namespace element has been left out intentionally as the permissions for the 
spring kubernetes library needs to be applied for it and I had trouble getting this
to work.
