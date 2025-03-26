# SassoCartaForbice

> **Progetto scolastico in Java** sviluppato in quarta superiore (2024) per approfondire la gestione dei **thread** in un ambiente simulato.
> Un gioco basato su **Sasso, Carta e Forbice**, in cui molteplici entità si scontrano all'interno di un cubo e si trasformano in base alle regole classiche del gioco, fino a quando ne rimane solo una.

<p align="center">
  <img src="banner.png" alt="SassoCartaForbice Gameplay" width="800"/>
</p>

---

## Sommario
- [Caratteristiche Principali](#caratteristiche-principali)
- [Funzionamento](#funzionamento)
- [Installazione e Utilizzo](#installazione-e-utilizzo)
- [Struttura del Progetto](#struttura-del-progetto)
- [Contributi e Sviluppi Futuri](#contributi-e-sviluppi-futuri)
- [Licenza](#licenza)

---

## Caratteristiche Principali

- **Gestione avanzata dei thread**  
  Ogni elemento (sasso, carta, forbice) è un thread indipendente che si muove nel cubo e interagisce con gli altri.

- **Scontri dinamici**  
  Quando due elementi si incontrano, avviene una trasformazione secondo le regole di *Sasso, Carta e Forbice*:
  - Sasso vs Carta → Il sasso diventa carta.
  - Carta vs Forbice → La carta diventa forbice.
  - Forbice vs Sasso → La forbice diventa sasso.

- **Simulazione realistica e casuale**  
  Il movimento degli elementi è casuale e imprevedibile, garantendo una simulazione unica ad ogni avvio.

- **Obiettivo del gioco**  
  La simulazione continua fino a quando rimane un solo tipo di elemento, decretando la "specie" dominante.

---

## Funzionamento

1. **Creazione dell'ambiente**  
   Il cubo viene popolato con un numero casuale di sassi, carte e forbici.

2. **Avvio dei Thread**  
   Ogni elemento è gestito da un thread separato che ne controlla il movimento e gli scontri.

3. **Interazioni e trasformazioni**  
   Quando due elementi si scontrano, si trasformano secondo le regole di gioco.

4. **Fine della partita**  
   Il gioco termina quando rimane un solo tipo di elemento nel cubo.

<p align="center">
  <img src="gameplay.gif" alt="SassoCartaForbice Simulation" width="800"/>
</p>

---

## Installazione e Utilizzo

1. **Clona il repository**  
   ```bash
   git clone https://github.com/tuo-nome-utente/SassoCartaForbice.git
   cd SassoCartaForbice
   ```

2. **Esegui il file JAR**  
   - Assicurati di avere installato [Java 8+](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Avvia il gioco con:
     ```bash
     java -jar SassoCartaForbice.jar
     ```

3. **Guarda la simulazione**  
   - Gli elementi inizieranno a muoversi nel cubo.
   - Osserva come si trasformano quando si scontrano.
   - Attendi fino a quando rimane un solo tipo di elemento.

---

## Struttura del Progetto

La struttura del progetto all'interno del JAR è la seguente:

```
SassoCartaForbice/
|
├─ META-INF/
│   ├─ MANIFEST.MF  # File manifest con informazioni sul JAR
│
├─ sassocartaforbice/
│   ├─ GUI.class         # Classe principale per l'interfaccia grafica
│   ├─ GestoreTipo.class # Classe che gestisce il comportamento degli elementi
│   ├─ objectTHR.class   # Classe che rappresenta un elemento (sasso, carta, forbice)
│   ├─ icon.png          # Icona del programma
│   ├─ rock.png          # Immagine per il sasso
│   ├─ paper.png         # Immagine per la carta
│   ├─ scissor.png       # Immagine per la forbice
│   ├─ pop.wav           # Suono degli scontri
│
├─ README.md  (da creare)
└─ ...
```

- **GUI.class**: gestisce l'interfaccia grafica del gioco.
- **GestoreTipo.class**: controlla la logica di trasformazione degli elementi.
- **objectTHR.class**: rappresenta un singolo elemento (sasso, carta o forbice) e ne gestisce il comportamento tramite thread.
- **Risorse (PNG e WAV)**: immagini e suoni per rendere l'esperienza più immersiva.

---

## Contributi e Sviluppi Futuri

- **Miglioramento delle interazioni**: aggiungere varianti di regole per aumentare la complessità.
- **Ottimizzazione dei thread**: esplorare soluzioni per migliorare la gestione della concorrenza.
- **Nuove modalità di gioco**: introdurre parametri configurabili come la velocità degli elementi o un timer.
- **Grafica migliorata**: potenziare l'interfaccia grafica per una rappresentazione più chiara degli scontri.

Se hai idee, apri una [issue](https://github.com/tuo-nome-utente/SassoCartaForbice/issues) o proponi una [pull request](https://github.com/tuo-nome-utente/SassoCartaForbice/pulls)!

---

## Licenza

Questo progetto è rilasciato sotto la licenza [MIT](LICENSE). Sentiti libero di utilizzarlo, modificarlo e distribuirlo, a condizione di mantenerne i riferimenti originali.

---

**Divertiti a esplorare il mondo del multithreading con *SassoCartaForbice*!**
Per qualsiasi dubbio o suggerimento, non esitare a [contattarmi](https://github.com/tuo-nome-utente).

