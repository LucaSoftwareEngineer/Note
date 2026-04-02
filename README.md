# 📝 EASY NOTES API (Spring Boot)

Questo progetto è un'applicazione backend per la gestione di note digitali, basata sul lavoro originale di **[Gixx17](https://github.com/Gixx17)**. 


## 🚀 Evoluzione e Refactoring

Partendo dal lavoro svolto da Gixx17, ho implementato le RestAPI necessarie per effettuare le operazioni CRUD.

### 🛠 Modifiche effettuate:
- **Database Fix**: Corretta la configurazione in `application.properties`, risolvendo i conflitti di accesso e i problemi di driver.
- **Architettura DTO**: Implementato il pattern Request/Response tramite DTO per separare le Entity di persistenza dallo strato API, migliorando la manutenibilità e la sicurezza del codice.
- **REST API**: Implementati i seguenti endpoint nel `NotaController`:
  - `POST /api/note/aggiungi`: Creazione di una nuova nota (Request: `AggiungiNotaRequest`).
  - `GET /api/note/elenco`: Recupero della lista completa delle note (`NotaResponse`).
  - `PUT /api/note/modifica`: Aggiornamento di una nota esistente (`ModificaNotaRequest`).
  - `DELETE /api/note/elimina/{id}`: Rimozione di una nota tramite ID.
- **Dipendenze**: Pulizia del `pom.xml` con passaggio a **Spring Boot 3.1.5 stabile** e driver `mysql-connector-j`.

### ✅ Test effettuati
* **Postman**: Verificato il corretto funzionamento di tutti i verbi HTTP (GET, POST, PUT, DELETE) con risposta `200 OK`.
* **Persistenza**: Confermata la creazione automatica delle tabelle e il salvataggio dei dati su **HeidiSQL**.
* **Stato Applicazione**: Risolti gli errori di avvio `Access denied` e corretta la lettura del file di configurazione sulla porta `8080`.

---

## ⚙️ Setup Rapido
1. Clona il fork: `git clone https://github.com/LucaSoftwareEngineer/Note.git`
2. Configura il tuo DB MySQL locale in `application.properties`.
3. Esegui con Maven: `mvn spring-boot:run`

---
*Contributo a cura di [LucaSoftwareEngineer](https://github.com/LucaSoftwareEngineer)*
