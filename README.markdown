Installation
==============
* Create a datasource "devoxx" in your application server
* Create a JMS Topic "topic/orders" in your application server

Open your browser to http://localhost:8080/ducttape/faces/index.xhtml

Glassfish 3.1.1
============
* Create a JMS ConnectionFactory named "jms/ConnectionFactory" in your application server

JBoss AS 7
============
* Remove seam-beans.xml from src/main/resources/META-INF/seam-beans.xml (Seam JMS can use the default configured ConnectionFactory in JBoss)

