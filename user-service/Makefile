.PHONY: all
all: config secret mongo user-service

.PHONY: config
config:
	kubectl apply -f mongodb-configmap.yaml

.PHONY: secret
secret:
	kubectl apply -f mongodb-secret.yaml

.PHONY: mongo
mongo:
	kubectl apply -f mongodb-deployment.yaml

.PHONY: user-service
user-service:
	kubectl apply -f user-service.yaml