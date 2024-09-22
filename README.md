
# Application de prise de notes

https://github.com/user-attachments/assets/e2b58950-eca0-4c74-b098-31c374ee0e23

## Description générale

Cette application de prise de notes est une application mobile Android développée en Kotlin. Elle permet à l'utilisateur de créer, modifier, afficher et supprimer des notes. L'application utilise la base de données locale **Room** pour stocker les notes, et **RecyclerView** pour afficher la liste des notes.

L'interface est simple et intuitive, avec un bouton flottant permettant d'ajouter de nouvelles notes, et des boutons individuels pour la mise à jour et la suppression des notes.

## Fonctionnalités principales

- **Afficher toutes les notes** : Les utilisateurs peuvent voir une liste de toutes les notes qu'ils ont créées.
- **Ajouter une nouvelle note** : Un bouton flottant permet d'ouvrir une interface pour ajouter une nouvelle note.
- **Mettre à jour une note** : Chaque note peut être modifiée en cliquant sur le bouton de modification correspondant.
- **Supprimer une note** : Chaque note peut être supprimée en cliquant sur le bouton de suppression correspondant.

## Architecture de l'application

L'application suit le modèle MVVM (Model-View-ViewModel) avec l'utilisation de **Room** pour la gestion de la base de données, **ViewModel** pour la gestion des données, et **RecyclerView** pour l'affichage de la liste des notes.

### Diagramme des composants

```
+---------------------+
|     MainActivity     |
+---------------------+
          |
          v
+---------------------+         +----------------+
|   NoteAdapter       | <-----> |   RecyclerView  |
+---------------------+         +----------------+
          |
          v
+---------------------+         +----------------+
|   NoteViewModel     | <-----> |   NoteRepository|
+---------------------+         +----------------+
          |
          v
+---------------------+         +----------------+
|    Room Database    | <-----> |     NoteDao     |
+---------------------+         +----------------+
```

### Explication des classes principales

1. **`MainActivity`** : L’activité principale qui affiche la liste des notes avec un `RecyclerView`. Un bouton flottant permet d’ajouter de nouvelles notes.
2. **`AddNoteActivity`** : Activité permettant d’ajouter une nouvelle note. Elle capture un titre et un contenu, puis enregistre la note dans la base de données.
3. **`UpdateNoteActivity`** : Activité permettant de modifier une note existante. Elle affiche le titre et le contenu de la note actuelle et permet de les mettre à jour.
4. **`NoteAdapter`** : Un adaptateur pour afficher les notes dans un `RecyclerView`.
5. **`NoteViewModel`** : Gère les données pour l'interface utilisateur. Il interagit avec le `NoteRepository` pour obtenir, insérer, modifier et supprimer des données.
6. **`NoteRepository`** : Interagit avec la base de données via le DAO (`NoteDao`) pour exécuter des opérations sur les données.
7. **`NoteDao`** : Interface pour interagir avec la base de données Room. Elle contient des méthodes pour insérer, mettre à jour, supprimer et obtenir des notes.

## Guide d'installation et de configuration

### Prérequis
- **Android Studio** : L'environnement de développement intégré (IDE) requis pour exécuter et tester l'application.
- **SDK Android 24** ou supérieur.
- **Émulateur Android** ou un appareil physique pour tester l'application.

### Installation
1. Clonez le projet depuis le dépôt GitHub (ou téléchargez les fichiers du projet).
2. Ouvrez le projet dans Android Studio.
3. Laissez Android Studio installer les dépendances nécessaires (via Gradle).
4. Assurez-vous que l'émulateur ou votre appareil est correctement configuré.
5. Cliquez sur le bouton **Run** dans Android Studio pour compiler et exécuter l'application.

## Manuel d'utilisation

### Écran d'accueil

Lorsque vous ouvrez l'application, vous arrivez sur l'écran d'accueil où vous pouvez voir la liste de toutes les notes créées. 

- **Bouton flottant en bas à droite** : En cliquant dessus, vous êtes redirigé vers l'écran d'ajout d'une nouvelle note.
- Chaque note s'affiche sous forme de carte, avec un titre et une description.

### Ajouter une nouvelle note

1. Cliquez sur le bouton flottant violet en bas à droite de l'écran d'accueil.
2. Une nouvelle page s'ouvre avec deux champs de texte :
    - **Titre de la note** : Entrez le titre de la note.
    - **Contenu de la note** : Entrez le contenu de la note.
3. Cliquez sur le bouton **Ajouter cette note** pour enregistrer la note dans la base de données.
4. Vous serez redirigé vers l'écran d'accueil, où la nouvelle note apparaîtra dans la liste.

### Mettre à jour une note

1. Sur l'écran d'accueil, chaque note a un bouton **Modifier** (icône de crayon).
2. Cliquez sur le bouton **Modifier** à côté de la note que vous souhaitez modifier.
3. Vous serez redirigé vers l'écran de mise à jour avec les champs préremplis avec les informations de la note.
4. Modifiez le titre ou le contenu, puis cliquez sur **Mettre à jour** pour enregistrer les modifications.
5. Vous serez redirigé vers l'écran d'accueil, où la note modifiée sera visible.

### Supprimer une note

1. Sur l'écran d'accueil, chaque note a un bouton **Supprimer** (icône de poubelle).
2. Cliquez sur le bouton **Supprimer** à côté de la note que vous souhaitez supprimer.
3. La note sera immédiatement supprimée de la base de données, et la liste des notes sera mise à jour.
