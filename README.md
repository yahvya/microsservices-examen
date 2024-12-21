# Examen microservices java

## Base de données

> Les bases de données seront des bases Sqlite disponible au niveau des ressources, le schéma sera crée avec le logiciel [looping](https://www.looping-mcd.fr/) et sera disponible dans chaque service au format png. L'application crée par défaut la base de données au lancement.

## Présentation de la structure et du fonctionnement des différents services

> Afin de pouvoir tester chaque service individuellement, des fichiers ".http" seront disponibles pour chaque service

## Api Calendar

Les credentials google ne pouvant pas être push sans désactivation pour que le code fonctionne pensez à suivre les étapes suivantes

- Créer un projet google cloud
- Ajouter l'api Google calendar avec les options de gestion de calendrier et d'évènements
- Une fois fait créer un compte de service
- Pour ce compte générer une clé qui sera sous format json
- placer ce fichier dans le dossier resources du projet appointment avec comme nom **credentials.json**