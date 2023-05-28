# PAO Proiectul 2
##### Corolevschi Mihai - Grupa 232

Baza de date a fost hostata pe Oracle XE.
Aplicatia se conecteaza la baza de date, folosind interfata DatabaseConnection.
DatabaseConnection este implementata direct the DatabaseManager, care este un singleton.
DatabaseManagerul are functional de a se conecta, deconecta si de a returna conectiunea.

Am implementat clasele Repository, care au functionalul de management al SQL-ului.
Ele pot adauga, sterge, modifica si selecta date din Oracle XE.
Ele implementeaza din clasa Repo, care la urma ei este o interfata Generica.
Pana cand avem doua clase Repository importante. UserRepo<Account> si SoftwareRepo<Software>.
Clasele ce implementeaza Repo, dau trigger la clasele Observer.

Am Implementat clasele Service, care conecteaza functionalul aplicatie cu cel al bazei de date.
Clasele Service pot adauga, modifica, sterge si genera urmatoare cheie primara din baza de date.
Ele implementeaza functionalul de Observer (listenAdd, listenRemove, listenModify) folosind consumer.
Cu ajutorul acestor clase, sterilizam obiectele adaugate noi (preluam din baza de date, cheile primare noi) pentru a nu avea coliziuni.

Am adaugat 3 design pattern-uri. Singleton, Observer si Facade
Singleton poate fi observat in clasele CSVWriter si DatabaseManager.
Observer poate fi observat in clasele Service (UserService, SoftwareService, UserRepo, SoftwareRepo)
Facade poate fi observat in clasa Controller, ea encapsuleaza functionalul permis de UserService si SoftwareService

Am implementat scriera in CSV folosind design patternul Observer. Odata ce detectam o schimbare la nivel de baza, scriem logguri in CSV.
Fisierul CSV se numeste audit.csv

Am implementat Thread-uri pentru a putea procesa un numar mare de cereri de scriere in Logguri.
El este implementat in CSVWriter si CSVWriterTask. Am folosit structuri de date threadsafe.
Functionalul de baza este adaugarea elementelor in Queue folosind CSVWriter si procesarea elementelor in CSVWriterTask.
Odata cu terminarea programului, threadul o sa proceseze tot Queue-ul pana la terminate.

Am implementat exceptiile DatabaseConnectionException, DatabaseDisconnectException si DatabaseQueryException.
Ele sunt foloside the DatabaseManager in momentul in care nu este posibila conectarea, deconectarea si utilizarea bazaei de date.

Am implementat Loggerul in CSV. Toate actiunile aplicatiei asupra bazei de date sunt inregistrate.
Actiunile pot fi Adaugarea, Stergerea si Modificare unor elemente.

Clasele Sealed si Non-sealed au fost folosite pentru design pattern-ul Observer. Clasa Observer este sealed si permite mosterirea doar claselor Repository, care la randul lor le foloseste functionalul.
Clasele Non-sealed sunt clasele UserRepository si SoftwareRepository.
 
Clasele generice sunt Service si Repo. Ele ambele o sa aiba nevoie de tipul de date odata cu implementarea lor.
Este necesar sa le stim din moment ce operam la nivel de aplicatie.
 
Nu am folosit iterator.
 
Am folosit Jackson Library pentru a serializa datele in CSV.
Fiecare actiune inregistrata, arata si obiectul inserat, modificat sau sters.
Stringul JSON a fost formatat, folosind caractere speciale pentru a fi compatibil cu formaul CSV-ului




# PAO Proiectul 1

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
##### Cu ajutorul acestei secvente de cod, putem sa:
1) Folosim functionalul din Servicii pentru a citi un user
2) Sa ii atribuim un wallet
3) Sa ii atribuim un singur soft
4) Sa ierarhia de referinte

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

walletService.modifyWallet(wallet);

user.setWallet(wallet);
user.setOwnedItems(gameSet);
```
##### Cu ajoturul acestei secvente, putem:
1) Sa creem un user
2) Sa ii atribuim un wallet
3) Sa citim un numar de softuri pe care le detine
4) Sa modificam wallet-ul actual
5) Sa creem ierarhia de referinte


