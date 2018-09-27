Groupe 3 Equipe 4
- CdC<br/>
Clair, précis et bien détaillé.

- Diagramme de cas d'utilisation<br/>
S'authentifier n'est pas un UC en soi.<br/>
Le BDE n'est pas une sorte d'étudiant (au sens des UC possibles)

- Descriptifs textuels
  - consulter info : il n'y a aucun échange, donc pas vraiment d'intérêt. Pourquoi cliquer si on voit l'info ? Ou alors pop-up, agrandissement, ... ?
  - attribuer les comptes : pas réellement de descriptif.<br/>
On voir une liste d'actions, mais pas réellement les échanges entre l'acteur et le système, ni le détail des données.

- Diagramme de classes<br/>
Il faudrait faire la différence entre les classes de données et d'interface par exemple Utilisateur afficherErreur.

- Diagrammes de séquence
  - attribuer compte<br/>
Inversion true false. Erreur retour de fonction pluôt qu'appel.
  - modifier IHM<br/>
La séquentialité n'est pas respectée sur les flèches 4 et 9.
  - proposer des informations<br/>
idem erreur flèche de retour de fonction.
  - connexion<br/>
Flèche 2 mal placée.
  - modification<br/>
Appel de fonction, suivi de résultat. Est-ce que l'appel est sur le bon destinataire ou il manque un représentant IHM ?

D'une façon générale, il y a une confusion sur la notion d'envoi de messages, qui ne correspond pas à l'appel d'une fonction : envoyerMail... à BDE ne correspond pas à une demande d'exécution de code par la classe BDE, mais plutôt à un interlocuteur qui ressemble à un serveur de mails.

Une remarque : relisez pour les fautes d'orthographe, sur un document professionnel, cela ne devrait pas se produire.

