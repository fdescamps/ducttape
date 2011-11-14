Installation
==============
* Create a datasource "devoxx" in your application server
* Create a JMS Topic "topic/orders" in your application server

Open your browser to http://localhost:8080/ducttape/faces/index.xhtml

Glassfish 3.1.1 (Full profile)
============
* Install Hibernate using the update manager (or change persistence.xml to use EclipseLink)
* Create a JMS ConnectionFactory named "jms/ConnectionFactory" in your application server

JBoss AS 7
============
* Remove seam-beans.xml from src/main/resources/META-INF/seam-beans.xml (Seam JMS can use the default configured ConnectionFactory in JBoss)


Notes
==========
@Asynchronous and @Scheduled are not supported by JBoss AS 7 yet because they are not part of the
Java EE 6 Web Profile. Will be supported in 7.1.

