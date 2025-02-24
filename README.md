# Springboot Backend con Java e Kotlin

Ciao a tutti,

Questo progetto è realizzato in collaborazione con **BacaroTech** e ha l'obiettivo di analizzare le differenze tra due backend sviluppati con **Spring Boot**, utilizzando due linguaggi distinti: **Java** e **Kotlin**.

L'obiettivo è confrontare le caratteristiche, i vantaggi e le peculiarità di ciascun linguaggio nell'implementazione di un backend moderno.



# Come lanciare il progetto

Il progetto è stato strutturato per essere facilmente eseguito sia tramite un **IDE** (IntelliJ, Eclipse, etc.), sia utilizzando **Docker**.

### Operazioni preliminari

1.  **Clonare il repository Git**  
    Clona il repository del progetto nella tua macchina locale:    
    `git clone https://github.com/FrigoTurcoMoreno/BacaroSpringbootJavaEKotlin` 
    
2.  **Creare il database (opzionale)**  
    Se desideri utilizzare un database in locale, esegui lo script del DDL (Data Definition Language) per creare la struttura del database. Puoi farlo utilizzando un client di database come **DBeaver**.
    Importa lo script SQL nel tuo gestore e crealo nel database di tua scelta.
    

## **Opzioni per eseguire il progetto**

### **1. Esecuzione tramite IDE**

1.  **Aprire il progetto**  
    Avvia il tuo **IDE** (come IntelliJ o Eclipse), e apri una copia del progetto. Assicurati di **aprire un singolo backend per ogni istanza** del progetto (uno per Java e uno per Kotlin).
    
2.  **Verifica la configurazione dell’ambiente**  
    Controlla che la versione di **Java** (OpenJDK 21) e il framework di build (**Maven** e **Gradle**) siano configurati correttamente nel progetto. Se necessario, configura l'ambiente di sviluppo.
    
3.  **Esegui l'applicazione**  
    Avvia il progetto cliccando sul tasto **Run** (o "Esegui") direttamente nel tuo IDE. L'applicazione Spring Boot partirà sulla porta predefinita (`http://localhost:8080` per Java e  `http://localhost:8081` per Kotlin).
    
 4. **Testare tramite Postman**  
Per testare le API, puoi utilizzare la **Postman Collection** fornita nel progetto. Importa la collection di Postman per eseguire facilmente tutte le richieste e verificare il corretto funzionamento dell'applicazione.

### **2. Esecuzione tramite Docker**

Se preferisci eseguire il progetto tramite **Docker**:

1.  **Lanciare Docker Compose**  
    Vai alla cartella principale del progetto nel terminale e avvia il container Docker con il seguente comando:
    `docker compose up`
    
2. **Testare tramite Postman**  
Come per l'esecuzione tramite IDE, puoi utilizzare la **Postman Collection** per testare tutte le API. Importa la collection di Postman e inizia a testare le funzionalità del progetto.

## **Tecnologie e Tool Utilizzati**

### **Tecnologie:**

-   **Java**
-   **Kotlin**
-   **Spring Boot**
-   **MySQL**

### **Tool:**

-   **Git** (per il controllo versione)
-   **Maven** o **Gradle** (per la gestione delle dipendenze e la build del progetto)
-   **Docker** (per l'esecuzione in container)
-   **Postman** (per il testing delle API)



## **Ringraziamenti Finali**

Un ringraziamento speciale a **BacaroTech** per la collaborazione a questo progetto. Grazie anche a te per aver dedicato del tempo a leggere e provare il nostro lavoro! La tua attenzione e disponibilità sono molto apprezzate.

Se hai domande o suggerimenti, non esitare a contattarci. Buon lavoro e buon divertimento con il progetto!

## Autore

[](https://github.com/FrigoTurcoMoreno/KotlinBE#author)

Moreno Frigo Turco

-   [![GitHub Icon](https://camo.githubusercontent.com/c05903c8a48be64bdad5eb755e4a50e7a5c9807eb36559a65bef1cafc703a1bc/68747470733a2f2f696d672e69636f6e73382e636f6d2f6d6174657269616c2d6f75746c696e65642f32342f6666666666662f6769746875622e706e67)](https://github.com/FrigoTurcoMoreno)  [GitHub](https://github.com/FrigoTurcoMoreno)
-   [![LinkedIn Icon](https://camo.githubusercontent.com/0c56f3a87a6c99b6bcf576e92b24c679fa53ffb334001b04afb12294c90d4fed/68747470733a2f2f696d672e69636f6e73382e636f6d2f6d6174657269616c2d726f756e6465642f32342f6666666666662f6c696e6b6564696e2e706e67)](https://www.linkedin.com/in/moreno-frigo-turco-4a423a294)  [LinkedIn](https://www.linkedin.com/in/moreno-frigo-turco-4a423a294)
-   [![Instagram Icon](https://camo.githubusercontent.com/788a89a641b46c3cde82edc9b65ac6245143753ec30991254eeb6680ab46cb1d/68747470733a2f2f696d672e69636f6e73382e636f6d2f6d6174657269616c2d726f756e6465642f32342f6666666666662f696e7374616772616d2d6e65772e706e67)](https://www.instagram.com/morenofrigo.dev)  [Instagram](https://www.instagram.com/morenofrigo.dev)
-   [![X Icon](https://camo.githubusercontent.com/6687431dc48a248e2e7d2f13af97aca440611fd76ce7a0bc2db28b57b10fe2e9/68747470733a2f2f696d672e69636f6e73382e636f6d2f6d6174657269616c2d726f756e6465642f32342f6666666666662f747769747465722e706e67)](https://x.com/morenofrigo_dev)  [X](https://x.com/morenofrigo_dev)