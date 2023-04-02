# PAO Proiectul 1
##### Corolevschi Mihai - Grupa 232

Ideea proiectului este de a putea gestiona si structura o baza de date pentru o platforma de Softuri.
Fiecare platforma este obligata sa aiba tipul de date Developer, User, Game, App si clasele de baze din care se mostenesc datele.

Un Developer poate sa dezvolte aplicatii sau jocuri, pe cand un user poate doar sa le detina.
Un Soft poate fi o aplicatie sau poate sa fie si un joc.

Pentru eliminarea redundatelor, au fost folosite Enum-uri si mosteniri.
Clasele User si Developer, ambele, mostenesc din clasa Account, care la randul sau are cateva campuri private.

Toate variabilele au fost encapsulate prin access modifiers si le-au fost generate cate un setter si getter.
 
Proiectul in sine, nu depinde de meniu. Toate serviciile incluse, ajuta la gestionarea si introducerea datelor in
aplicatie, insa gestionarea si traversarea prin meniu este pusa la discretia programatorului.

Am sa las cateva linii de cod demo pentru a arata functionalul

```JAVA
Scanner s = new Scanner(System.in);
User user = userService.addUser(s);
Wallet wallet = walletService.addWallet(s);

Software soft = softwareService.addSoftware(s);
ArrayList<Software> gameSet = new ArrayList<>();
gameSet.add(soft);

user.setWallet(wallet);
user.setOwnedItems(gameSet);
```
##### Cu ajutorul acestei secvente de cod, putem citii de la tastatura, un User, un Wallet pentru user si deja un Soft care il detine

```JAVA
Scanner s = new Scanner(System.in);
User user = userService.addUser(s);
Wallet wallet = walletService.addWallet(s);


ArrayList<Software> gameSet = new ArrayList<>();
System.out.println("Number of softwares owned: ");
int nr = s.nextInt();
for (int i = 0; i < nr; i++){
    Software soft = softwareService.addSoftware(s);
    gameSet.add(soft);
}

user.setWallet(wallet);
user.setOwnedItems(gameSet);
```
##### Cu ajutorul acestei secvente, putem:
1) Sa creem un user
2) Sa ii atribuim un wallet
3) Sa il setam un numar de softuri pe care le detine
4) Sa creem ierarhia de referinte
