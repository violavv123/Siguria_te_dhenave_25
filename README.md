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
(sigurohuni që jeni brenda folderti src/ kur përdorni komandat java dhe javac):
```bash
javac src/Vigenere.java
java src.Vigenere
javac src/TurningGrille.java
java src.TurningGrille
```
**_4._** Pra varësisht se cilin alogirtëm dëshironi të përdorni për enkriptim dhe dekriptim, zgjedhni klasën
java përkatëse.

**_5._** Nëse po përdorni një IDE, mund ta ekzekutoni programin edhe thjesht duke klikuar butonin "Run" 
pa pasur nevojë të përdorni terminalin. Gjithashtu Java JDK e instaluar rekomandohet të jetë e versionit
8+.

**_6._** Në algorimtin Vigenere Cipher pas ekzekutimit të programit do të pritet të shfaqet mesazhi i enkriptuar
dhe i dekriptuar, kurse mesazhi dhe passwordi editohen brenda kodit jo në terminal. Në algorimtin
Turning Grille Cipher ofrohet menzja interaktive në terminal e cila ofron dy opsione: enkriptimi dhe 
dekriptimin.

## **Pershkrimi i Algoritmit**
### 1. Vigenère Cipher
Vigenère Cipher është një nga algoritmet më të njohura të kriptimit polialfabetik,
i zhvilluar nga kriptografi francez Blaise de Vigenère në shekullin e 16-të. Ndryshe nga shifrat e thjeshta monoalfabetike (si Caesar Cipher), Vigenère përdor një çelës (fjalkalim) për të krijuar zhvendosje të ndryshme për secilën shkronjë, 
duke e bërë më të vështirë thyerjen e tij përmes analizës së frekuencës.
Një nga avantazhet kryesore të Vigenère është se përdor një çelës të ndryshëm për çdo shkronjë të mesazhit, duke e bërë më të vështirë për të zbuluar mesazhin krahasuar me metodat e tjera, siç është Caesar Cipher. Megjithatë, nëse çelësi është i njohur ose i parashikueshëm, mund të thyhet relativisht lehtë, sidomos nëse mesazhi është i gjatë dhe mund të zbulohet një pattern në përdorimin e çelësit.
Vigenère Cipher ka qenë një nga metodat më të njohura për kriptimin e mesazheve për shumë kohë, por tani përdoren algoritme më të avancuara dhe më të sigurta, si AES (Advanced Encryption Standard), për kriptimin e të dhënave të ndjeshme.

#### Hapat per enkriptim:
**1.Përgatitja e tekstit dhe çelësit:**
   - Konverto të gjitha shkronjat në UPPERCASE.
   - Largo karakteret jo-alfabetike ose mbaji të pandryshuara (opsionale).

**2.Përsëritja e çelësit:**
- Nëse çelësi është më i shkurtër se teksti, ai përsëritet ciklikisht.
- P.sh., për tekstin "HELLOWORLD" dhe çelësin "KEY", çelësi bëhet "KEYKEYKEYK".

**3.Llogaritja e zhvendosjes:**
- Për çdo shkronjë P në tekst dhe shkronjën korresponduese K në çelës:
- Konverto P dhe K në indekse numerike (A=0, B=1, ..., Z=25).

**4.Apliko formulën:**

- C = (P + K) mod 26
- Konverto rezultatin C përsëri në shkronjë.
- Shembull i Plotë:
- Teksti i thjeshtë: "HELLO"
- Çelësi: "KEY"

- H(7) + K(10) = 17 → R  
- E(4) + E(4) = 8 → I  
- L(11) + Y(24) = 35 → 35 mod 26 = 9 → J  
- L(11) + K(10) = 21 → V  
- O(14) + E(4) = 18 → S  
**Rezultati: "RIJVS"**

### Hapat për dekriptim

1. **Përgatitja e tekstit dhe çelësit:**

    - Konverto **mesazhin e enkriptuar** (ciphertext) dhe **çelësin** në **shkronja të mëdha** (UPPERCASE).
    - Largo ose trajto karakteret jo-alfabetike nëse është e nevojshme (mund të mbeten të pandryshuara).

2. **Përsëritja e çelësit:**

    - Nëse çelësi është më i shkurtër se ciphertext, ai duhet të **përsëritet ciklikisht** derisa të mbulojë gjithë gjatësinë e tekstit të enkriptuar.
    - **Shembull**:
      ```
      Teksti i enkriptuar: "RIJVS"
      Çelësi: "KEY" → përsëritet si "KEYKE"
      ```

3. **Llogaritja e zhvendosjes për dekriptim:**

    - Për çdo shkronjë `C` në tekstin e enkriptuar dhe shkronjën përkatëse `K` nga çelësi:
        - Konverto të dyja në indekse numerike (A = 0, B = 1, ..., Z = 25).
        - Apliko formulën për dekriptim:

          ```
          P = (C - K + 26) mod 26
          ```

        - Ku:
            - `P` është pozita e shkronjës së plaintext-it
            - `C` është pozita e shkronjës së enkriptuar
            - `K` është pozita e shkronjës në çelës
            - `+26` siguron që rezultati të jetë pozitiv

4. **Konvertimi në shkronja:**

    - Pas llogaritjes së çdo `P`, konverto rezultatin përsëri në shkronjë për të rindërtuar tekstin e dekoduar.

---
####  Shembull i plotë:

**Ciphertext: R I J V S Çelësi: K E Y K E**

- R(17) - K(10) = 7 → H
- I(8) - E(4) = 4 → E
- J(9) - Y(24) = -15+26=11 → L
- V(21) - K(10) = 11 → L
- S(18) - E(4) = 14 → O

**Teksti i dekriptuar: `HELLO`**


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

#### Hapat për dekriptim:
1. Teksti i enkriptuar mbush matricën 4x4.
2. Grille kontrollon pozitat ku janë true dhe karakteri qe gjendet në të njejten pozitë në matricë ruhet në një string.
3. Grille rrotullohet 4 herë 90° që të lexohen të gjitha karakteret.
4. Karakteret e ruajtura në string pas çdo rrotullimi kthejnë si rezultat tesktin e dekriptuar.

### Rezultatet e ekzekutimit në algoritmin Vigenere :

###  1. Enkriptimi

Gjatë ekzekutimit të programit, përdoruesi jep një mesazh tekstual dhe një çelës. Në këtë demonstrim:

- **Mesazhi origjinal**:  
  `SHIHEMI NE ROUTE 66 NE ORA 6`

- **Çelësi i përdorur për enkriptim**:  
  `LIMONI`

Algoritmi transformon shkronjat alfabetike përmes zhvendosjes sipas shkronjave të çelësit, ndërsa karakteret jo-alfabetike (si hapësirat dhe numrat) ruhen të pandryshuara.

**Mesazhi i enkriptuar është:**
`DPUVRUT VQ FBCEM 66 ZS BZL 6`

### 2. Dekriptimi

Pas enkriptimit, algoritmi është në gjendje të rikthejë tekstin origjinal duke përdorur të njëjtin çelës.

- **Teksti i enkriptuar**:  
  `DPUVRUT VQ FBCEM 66 ZS BZL 6`

- **Çelësi për dekriptim**:  
  `LIMONI`

**Mesazhi i rikuperuar pas dekriptimit është:**
`SHIHEMI NE ROUTE 66 NE ORA 6`


### Rezultatet e ekzekutimit në algoritmin Turning Grille (Fleissner Grille)

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


