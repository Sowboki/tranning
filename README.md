# Projet de Simulation : Magasin d'Instruments de Musique et Gestion d'Animaux dans une Jungle

## Première partie

### Partie 1 - Magasin d’Instruments de Musique

1. **Structure du Magasin**
   - **Trésorerie** : Le magasin commence avec **10 000 euros** en trésorerie.
   - **Loyer** : Il paie un loyer mensuel de **2 000 euros**.
   - **Stock d’Instruments** : Le magasin maintient un stock initialement vide d’instruments.
   - **Catégories d’Instruments** : Les instruments sont classés en catégories, notamment :
     - Pianos (à queue, numérique, droit, queue)
     - Guitares (classiques, électriques)
     - Instruments à vent (flûte traversière, clarinette, hautbois)
   - **Caractéristiques des Instruments** : Chaque instrument a des caractéristiques spécifiques telles que le nom, le prix d’achat, le prix de vente, etc.

2. **Opérations du Magasin**
   Le magasin effectue les opérations suivantes :
   - **Ajout d’Instruments** : Ajouter des instruments au stock.
   - **Retrait d’Instruments** : Retirer des instruments du stock.
   - **Fourniture d’Instruments** : Fournir de nouveaux instruments en fonction de la trésorerie.
   - **Vente d’Instruments** : Vendre des instruments aux clients.

3. **Simulation de Fonctionnement**
   Le magasin peut simuler son fonctionnement sur **douze mois** :
   - Les ventes varient en fonction du mois et sont basées sur le prix de vente des instruments (inférieur ou égal à **3 500 euros**).

4. **Exemple d’Utilisation**
   Un exemple d’utilisation est fourni dans la méthode `main()` :
   - Ajout d’Instruments au Stock.
   - Opérations de Fourniture et de Vente.
   - Simulation de Fonctionnement sur une année complète.

## Deuxième partie

### Partie 2 - Gestion d’Animaux dans une Jungle

Cette partie présente une simulation de la gestion d’animaux dans une jungle virtuelle. Le code est structuré en trois classes principales : **Animal**, **Carnivore** et **Herbivore**, chacune modélisant un aspect spécifique du comportement des animaux dans cet environnement simulé.

5. **Structure du Code**
   Le code est organisé de manière hiérarchique, avec une classe de base **Animal**, et deux sous-classes **Carnivore** et **Herbivore**, héritant des propriétés et des méthodes de la classe de base. Cette structure permet de définir des comportements spécifiques pour les différents types d’animaux.

6. **Classe Animal**
   La classe **Animal** sert de classe de base pour tous les animaux de la jungle. Elle définit les attributs communs tels que le nom, l’âge, le niveau de faim, la taille, le sexe et l’âge de reproduction. La classe comporte également des méthodes pour simuler divers aspects de la vie des animaux, y compris le vieillissement, la faim, la reproduction et la mort.

7. **Classes Carnivore et Herbivore**
   Les classes **Carnivore** et **Herbivore** sont des sous-classes de la classe Animal. Chacune de ces classes spécialisées hérite des propriétés de la classe de base, mais elles ont des comportements spécifiques. Les carnivores sont capables de chasser des herbivores, tandis que les herbivores peuvent brouter de l’herbe pour se nourrir.

8. **Fonctionnement du Code**
   Le code simule la vie des animaux dans la jungle sur une période de **six jours**. Il prend en compte des actions telles que le vieillissement, la faim, les cris des animaux, la reproduction et la chasse des carnivores. Des événements aléatoires, tels que la chasse réussie ou la naissance d’un nouvel animal, sont également pris en compte pour rendre la simulation plus réaliste.
