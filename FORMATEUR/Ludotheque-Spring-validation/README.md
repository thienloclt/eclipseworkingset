# Spring MVC Project: Gestion de CD

Relation oneToMany avec formulaire, example d'internationnalisation, param POST et GET

## Description 
Divers élements concernant Spring-MVC:
 - WelcomeController: contient différentes URLs pour montrer la différence entre les PathVariable et les RequestParam, Des methodes sont mapés sur une JSP pour montrer les variable GET, d'autres le sont sur une JSP montrant les variables POST.
 - ArtisteController et CdController permet un crud de Entités avec gestion des relations (uni directionnel)
 
## Configuration DB:
Property file:db.properties
	database.name=springMusic
	database.login=root
	database.passwd=passwd
	database.hbm2ddl=update
	database.dialect=org.hibernate.dialect.MySQL57Dialect