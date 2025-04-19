# Siguria_te_dhenave_25
Projekti 2 - Vigenere Cipher dhe Turning Grille (Fleissner Grille)

## **Udhëzime për Ekzekutimin e Programit**

**_1._** Për të nisur punën me projektin, së pari klononi repository-në në kompjuterin
tuaj lokal duke përdorur komandën:
 ```bash
git clone https://github.com/violavv123/Siguria_te_dhenave_25
```

_**2.**_ Pasi të keni klonuar projektin, hapeni atë në një ambient zhvillimi (IDE) si IntelliJ IDEA, 
Visual Studio Code, apo çfarëdo IDE tjetër që e mbështet Java.

**_3._** Për të kompiluar dhe më pas ekzekutuar programin, përdorni komandat më poshtë në terminal 
(sigurohuni që jeni brenda folderit të projektit):
```bash
javac src/*.java
java src.Main
```

**_4._** Nëse po përdorni një IDE, mund ta ekzekutoni programin edhe thjesht duke klikuar butonin "Run" 
pa pasur nevojë të përdorni terminalin.

## **Pershkrimi i Algoritmit**
### 2. Turning Grille (Fleissner Grille)

Turning Grille Encryption është një teknikë klasike e fshehtësisë ku përdoret një grilë (shabllon me vrima)
mbi një tabelë me tekst. Grila vendoset mbi tabelë dhe përmes vrimave shkruhet mesazhi. Pastaj grila rrotullohet
(zakonisht 90°) disa herë për të plotësuar tabelën me pjesët e tjera të mesazhit. Marrësi që ka të njëjtën grilë mund ta
lexojë mesazhin duke e rrotulluar në të njëjtin rend.
Në thelb, është një kriptim simetrik me çelës vizual (grilën), që siguron siguri përmes fshehjes së rendit të shkronjave

#### Hapat per enkriptim:
1. Krijo matricën bosh n x n dhe mbushe me karakterin '*'.
2. Vendos grilën në pozicionin fillestar.
3. Për çdo rrotullim (4 herë):
   Shkruaj shkronjat e mesazhit në pozicionet true të grilës.
   Rrotullo grilën 90° majtas.
4. Pas plotësimit, lexo matricën rresht pas rreshti për të marrë tekstin e enkriptuar.


#### Rezultatet e ekzekutimit në algoritmin Turning Grille (Fleissner Grille)

Për qëllime demonstrimi, kemi marrë shprehjen: 
**_`grupi15`_**

1. **Enkriptimi**:  
   Shprehja origjinale kalon ne procesin e enkriptimit permes Turning Grille dhe na kthehet shprehja:  
   **`G**I1**R*5U**P**`**  
   (ku pozitat e zbrazëta janë te mbushura me * dhe karakteret transformohen në uppercase).

2. **Dekriptimi**:   
   Në vijim, për procesin e dekriptimit, marrim shprehjen e enkriptuar  
   `G**I1**R*5U**P**`  
   dhe bëjmë dekriptimin e shprehjes, që rezulton ne shprehjen e fillimit:  
   **`GRUPI15`**  
   (karakteret * eliminohen dhe kjo poashtu transformon shprehjen ne uppercase).


