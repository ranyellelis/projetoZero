# projetoZero
Projeto com as tecnologias: EJB 3.1 + JSF2 + CDI + Primefaces + JPA2 + JBoss AS 7.1.1.Final "Brontes"


Depois de baixar o driver JDBC do MySQL, é necessário instalar o driver como um módulo do JBoss. No diretório do JBoss, na pasta modules crie a estrutura de sub-pastas  \com\mysql\main, e copie o jar do driver dentro dessa pasta.

Nessa pasta, crie o arquivo module.xml, com o conteúdo a seguir:

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.1.17-bin.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
    <module name="javax.transaction.api"/>
  </dependencies>
</module>

Dentro do arquivo standalone.xml coloque as linhas dentro de <drivers>

<driver name="mysql" module="com.mysql">
  <driver-class>com.mysql.jdbc.Driver</driver-class>
  <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
</driver>


