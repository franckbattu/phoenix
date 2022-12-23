# Java Spring

Le but est d'avoir un projet template avec l'implémentation de toutes les fonctionnalités qui peuvent être utiles sur d'autres projets.

## Résumé
- Mise en place de l'i18n sur les entités JPA
    * Comment récupérer tous les champs localized sur une requête `SELECT *` ?
    * Comment récupérer les champs localized sur une requête unitaire avec un `JOIN` ?
    * Dans quelle couche doit être la levée de l'exception ? Service ou Controller ?

## Reste à faire
- Mise en place de workflow via state machine
- Mise en place de l'authentification JWT (access token / refresh token)
- Mise en place d'utilisateurs avec roles
- Les bonnes pratiques de développement en Java Spring

## Commandes

**Installation de dépendances**
```
./mvnw install
```

**Lancer l'application**
```
./mvnw spring-boot:run
```
