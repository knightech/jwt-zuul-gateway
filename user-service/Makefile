.PHONY: all
all: config secret mongo user-service


.PHONY: config
config:
	kubectl apply -f mongodb-configmap.yaml

.PHONY: secret
config:
	kubectl apply -f mongodb-secret.yaml

.PHONY: mongo
config:
	kubectl apply -f mongodb-deployment.yaml


.PHONY: user-service
config:
	kubectl apply -f user-service.yaml