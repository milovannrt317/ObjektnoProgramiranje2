Uputstva za projekat OP2-K3-2019

- Projekat maksimalno vredi 10 bodova.
- GUI realizovati u JavaFX tehnologiji.
- Klijent-server komunikacija koristi ili TCP ili UDP.

- Implementirati po 1 servis (odabran po želji) iz svake od 3 grupe servisa:

  1. grupa: 
    - unos i slanje datuma rođenja (server vraća podatke o bioritmu za tekući dan)
	  vraća se vrednost od -100 do +100 za emocionalni, fizički i intelektualni ritam
	- unos i slanje broja od 5 do 30 koji predstavlja centralni broj u matrici 3x3
	  server vraća magični kvadrat prirodnih brojeva
	  zbir svakog reda ili kolone ili dijagonale je isti i minimalan je
	- unos i slanje stringa (server vraća podatak da li je reč o palindromu)
	  razmaci se ne računaju

  2. grupa:
    - slanje odabrane datoteke iz foldera DATA_KLIJENT na server
	- prijem odabrane datoteke sa serverovog foldera DATA_SERVER
	- slanje podataka o 3 linearne jednačine sa 3 nepoznate (server vraća rešenje sistema)

  3. grupa:
    - klijent prikazuje lavirint 9x9 karaktera (' ' slobodno, '@' zid, 'R' (robot), 'E' (izlaz))
	  neka je dat početni lavirint koji može da se edituje:
	    @@@@@@@@@
	    @     R @
	    @ @@@@@ @
	    @  @    E
	    @@ @ @@@@
	    @       @
	    @ @@@@@ @
	    @       @
	    @@@@@@@@@
	  server vraća jedan put od R do E (npr. Desno,Dole,Dole,Desno)
	- klijent šalje svoj id i broj od 0 do 1000000,
	  server odgovara da li je to najmanji jedinstven poslan broj i vraća klijentu
	  preostali broj sekundi do kraja kviza
	  ako je vreme isteklo, onda server vraća id pobednika i najmanji jedinstven broj
	- svi klijenti (maksimalno 4) konferencijski chat-uju preko servera
	  poruku jednog klijenta vide svi konektovani klijenti
	  
Projekat se brani kod kolege Dušana Markovića pre januarskog ispitnog roka.

Srdačan pozdrav,
profesor Štrbac
