sudo apt-get update
sudo apt-get install openjdk-17-jdk -y

java -version

-----------------------------

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

java -version

-----------------------------

touch docker-compose.yml
nano docker-compose.yml

```version: '3.8'
services:
  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: adopta_un_junior
    ports:
      - "3306:3306"
```

**Iniciar**
docker-compose up -d

**Verificar estado.**
docker ps

-----------------------------

**Permisos**
chmod +x mvnw

**Compilamos proyecto.**
./mvnw clean install

./mvnw spring-boot:run

---------------------------

**Si cerramos la terminal o reiniciamos el codespace.**
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

java -version

docker-compose up -d
./mvnw spring-boot:run

----------------------------

**Configutamos java 17 por defecto.**

nano ~/.bashrc
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

----------------------------

**Iniciar docker-compose automáticamente**
touch ~/start.sh
nano ~/start.sh

#!/bin/bash
docker-compose up -d

permisos
chmod +x ~/start.sh

nano ~/.bashrc
Añadimos: ~/start.sh

source ~/.bashrc

----------------------------

**Verifica que Docker esté corriendo:**
docker ps

**Puedes verificar que tu servicio MySQL está corriendo:**
docker-compose ps