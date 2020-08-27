# k8s-camel-spring


## Build docker image
`docker build --rm -t artizan.org/spring-camel:1.0 .`

`docker build --rm --build-arg http_proxy=$http_proxy -t artizan.org/spring-camel:1.0 .`

`docker run -it artizan.org/spring-camel:1.0 sh`

## Deploy in k8s cluster
1. Run `kubectl create -f k8s-camel-spring.deployment.yml`
2. Run `kubectl get pods` to see the pod.
3. Run `k exec [k8s-camel-spring] -it sh` to shell into the container. Type `exit` to exit the shell.













[https://alpine.pkgs.org/3.12/alpine-community-aarch64/openjdk11-jre-headless-11.0.7_p10-r1.apk.html]