
all: build

install:
	mvn clean install

build: install
	mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
	docker build -t springio/gs-spring-boot-docker .

run: build
	docker run -p 8080:8080 springio/gs-spring-boot-docker

rundb:
	docker stack deploy -c stack.yml postgres