# Proiect_PAO

## Nume: Mustatoiu Ioan-Sebastian, grupa 332

### Tema proiect : Platforma Food Delivery


Clase : Local, Meniu, CategorieProduse, Produs, Recenzie, Cont, Client, Sofer, Comanda, FoodDeliveryService, in pachetul FoodDelivery

## Utilizare sistemului:

### 1.Crearea unui local:

```java
service.creeazaLocal("nume local", "adresa", "numar de telefon");
```

### 2.Cautarea unui local dupa nume:
```java
System.out.println(service.cautaLocalDupaNume("nume local"));
```

### 3.Crearea unui client:
```java
service.creeazaContClient("nume", "prenume", "email", "numar de telefon", "parola");
```

### 4.Cautarea unui client dupa email:
```java
System.out.println(service.cautaClientDupaEmail("email") + "\n");
```

### 5.Crearea unui sofer:
```java
service.creeazaContSofer("nume", "prenume", "email", "numar de telefon","parola", "numa de inmatriculare");
```

### 6.Cautarea unui sofer dupa email:
```java
System.out.println(service.cautaSoferDupaEmail("email") + "\n");
```

### 7.Afisarea tuturor clientilor/soferilor:
```java
service.afiseazaConturiClienti();
service.afiseazaConturiSoferi();
```

### 8.Crearea unui produs:
```java
FoodDelivery.Produs produs = service.creeazaProdus("nume produs", pret, gramaj, id categorie);
```

### 9.Crearea unei categorii de produse:
```java
FoodDelivery.CategorieProduse categorie = service.creeazaCategorie("nume categorie");
```

### 10.Adaugarea unui produs la o categorie:
```java
service.adaugaProdusLaCategorie(produs, categorie);
```

### 11.Crearea unui meniu:
```java
FoodDelivery.Meniu meniu = service.creeazaMeniu();
```

### 12.Adaugarea unei categorii la un meniu:
```java
service.adaugaCategorieLaMeniu(categorie, meniu);
```

### 13.Setarea unui meniu pentru un restaurant:
```java
FoodDelivery.Local local = service.cautaLocalDupaNume("nume local");
service.adaugaMeniuLaLocal(meniu, local);
```

### 14.Afisarea unui restaurant:
```java
System.out.println(local);
```

### 15.Afisarea localurilor:
```java
service.afiseazaLocaluri();
```

### 16.Crearea unei recenzii:
```java
FoodDelivery.Recenzie recenzie = service.creeazaRecenzie("recenzie", nota);
```

### 17.Adaugarea unei recenzii la un restaurant:
```java
service.adaugaRecenzieLocal(local, recenzie);
```

### 18.Crearea unei comenzi:
```java
List<FoodDelivery.Produs> cos= new ArrayList<>();
        cos.add(produs1);
        cos.add(produs3);
        cos.add(produs5);

service.creazaComanda(client, "adresa", cos, sofer);
```

### 19.Afisarea comenzilor:
```java
service.afiseazaComenzi();
```

### 20.Afisarea istoricului comenzilor unui client:
```java
client.afisareIstoricComenzi();
```

### 21.Inserarea unui local/client/meniu/categorie/produs in baza de date:
```java
//bazaDeDate.insereaza___(local/client/meniu/categorie/produs);
```

### 22.Stergerea unui local/client/meniu/categorie/produs in baza de date:
```java
//bazaDeDate.sterge___(nume/id/email);
```

### 23.Afisarea unui local/client/meniu/categorie/produs in baza de date:
```java
//bazaDeDate.afiseaza___(nume/email/id);
```

### 24.Exemplu de actualizarea a unui produs:
```java
int productId = id;
bazaDeDate.afiseazaProdus(productId);
Produs produsActualizat = new Produs("nume", pret, gramaj, id_categorie);
produsActualizat.setId(productId);

bazaDeDate.actualizeazaProdus(produsActualizat);
```




































