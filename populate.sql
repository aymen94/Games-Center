#Categoria
INSERT INTO gamedb.Categoria (nome) VALUES
	('Azione'),
	('Avventura'),
	('FPS'),
	('Simulazione'),
	('Strategia'),
	('Sport'),
	('Picchiaduro'),
	('Altro');

#PEGI
INSERT INTO gamedb.Pegi (id,icona,descrizione) VALUES
	(3,'3.jpg','Materiale specifico consigliato ed adatto a qualunque fascia d\'età. I personaggi possono essere o assolutamente fantastici e cartoonistici e quindi non paragonabili a esseri umani reali, oppure personaggi umani realistici di certi simulatori sportivi. La violenza, laddove presente, è riferibile sempre e comunque a un contesto fantastico-comico e in molti di questi giochi può essere addirittura completamente assente. Sono assenti rumori o immagini che possano indurre sentimenti di paura nei più piccoli, così come contenuti come linguaggio volgare, droga, nudità, sesso e qualsiasi attività riferibile e adatta ad un solo ambito adulto.'),
	(7,'7.jpg','Nonostante siano giochi completamente cartoonistici, questa è la prima classificazione PEGI a contenere restrizioni (comunque non troppo suggestive) per un pubblico molto giovane. Questi giochi sono caratterizzati della presenza, comunque non assidua, di particolari rumori o immagini cartoonistiche e fantasy che possono indurre sentimenti di spavento. Occasionalmente sono presenti scene di nudità parziale, ma mai riferibili a un contesto sessuale. La violenza rimane di livello medio-basso tipicamente fantasy e cartoonistica, ma leggermente più esplicita che nella fascia PEGI 3.'),
	(12,'12.jpg','Adatta alla fascia di pre-adolescenti, questa categoria raggruppa molti giochi cartoonistici e fantasy in modo simile a quella PEGI 7, ma implica la presenza di una violenza leggermente esplicita verso personaggi di fantasia, oppure una violenza non esplicita verso personaggi realistici, di aspetto umano o animale. Presenza di nudo più esplicita, anche se non assimilabile a un\'attività sessuale. Possibile presenza di un leggero turpiloquio; in ogni caso le espressioni volgari non contengono riferimenti al sesso. La violenza, rimasta cartoonistica, rimane di livello medio.'),
	(16,'16.jpg','Adatto a un pubblico prevalentemente adolescente, i giochi che rientrano in questa categoria presentano una violenza realistica di livello leggermente più alto delle altre categorie nonché la descrizione di attività sessuali assimilabili alla vita reale, seppure di contenuto non pornografico. Il linguaggio può avere forti connotazioni scurrili, e in più possono essere descritte scene che indichino l\'uso di droghe, alcool e tabacco o la propensione ad attività criminali.'),
	(18,'18.jpg','Adatto alla maggiore età, questo gruppo implica la descrizione di scene di violenza molto realistiche, a volte così pesanti da indurre sentimenti di disgusto e repulsione. Per violenza si intende non solo la presenza di ferite, mutilazioni e morte di personaggi assolutamente realistici, ma anche l\'eventuale presenza di immagini o rumori che possano alterare il normale stato psicologico della persona, provocando sensazioni di paura, angoscia o stress; è inoltre presente una quantità di sangue che spesso si può modificare od annullare grazie a delle opzioni.
Il linguaggio può essere estremamente volgare, le scene di sesso possono avere connotazioni esplicite così come l\'uso di sostanze stupefacenti.');

#Lingua
INSERT INTO gamedb.Lingua(nome) VALUES
  ("Italiano"),
  ("English"),
  ("Français"),
  ("Español"),
  ("Deutsch");

#Produttore
INSERT INTO gamedb.Produttore(sigla, nazionalita, nome) VALUES
("EA","us", "Electronic Arts"),
("AC", "us", "Activision"),
("UB", "fr", "Ubisoft"),
("SO", "jp", "Sony"),
("T2","us", "Take-Two Interactive"),
("SE","jp", "SEGA"),
("TH", "us", "THQ"),
("MS","us", "Microsoft"),
("SQ","jp", "Square Enix"),
("KO","jp", "Konami"),
("VC","us","Valve Corporation"),
("NA","jp", "Namco Bandai"),
("CA","jp", "Capcom"),
("BD","js", "Bandai"),
("DI","us", "Disney"),
("HG","bg","Haemimont Games"),
("CO","uk", "Codemasters"),
("EI","uk", "Eidos Interactive"),
("TW","us", "Total War"),
("RG","us", "Rockstar Games");

#Cliente
INSERT INTO gamedb.Cliente(nome,cognome,email, family_id, data_nascita, password) VALUES
("Aymen", "Naghmouchi", "aymen.aymen@live.it",0,"1994-10-02","5E884898DA28047151D0E56F8DC6292773603D0D6AABBDD62A11EF721D1542D8"),

#Prodotto
INSERT INTO gamedb.Prodotto(titolo,prezzo,anno,descrizione,tipo,produttore,pegi,categoria,cover,copie_disponibili,visualizzazioni) VALUES
("Grand Theft Auto III",0.30,2001,"Claude Speed organizza una rapina ad una banca di Liberty City con la sua ragazza, Catalina (Cynthia Farrell). Terminata la rapina, Catalina tradisce Claude, rubando il denaro e dandosi alla fuga insieme a Miguel, boss del Cartello Colombiano. Nonostante Claude venga ferito dalla ragazza, sopravvive e viene arrestato. Durante il trasporto al penitenziario, il convoglio su cui sta viaggiando viene attaccato dal Cartello Colombiano. Claude ne approfitta per scappare insieme a 8-Ball (doppiato dal rapper Guru), un esperto in esplosivi. Grazie alle conoscenze di quest'ultimo riusce a trovare un lavoro negli ambienti della Mafia italoamericana, iniziando dapprima a svolgere delle missioni per Luigi Goterelli (Joe Pantoliano), il proprietario del Sex Club 7 nel quartiere a luci rosse, per poi conoscere tutti i membri più potenti della famiglia Leone: il boss Salvatore Leone (Frank Vincent), il figlio Joey (Michael Rapaport), Toni Cipriani (Michael Madsen) e la moglie del boss, Maria Latore (Debi Mazar).",1,"RG",18,2,"GTA_3.jpg",100,10),
("Grand Theft Auto: San Andreas",5.99,2004,"Carl Johnson, detto CJ, è un delinquente di strada afroamericano, membro fino al 1987 della Grove Street Family, una gang delle periferie di Los Santos. In quell'anno, suo fratello minore, Brian rimane ucciso mentre era sotto la responsabilità di CJ; sentendosi in colpa con la sua famiglia, Carl decide di abbandonare la città venendo così reputato un vigliacco dagli amici del quartiere. Carl si trasferisce quindi a Liberty City, dove trascorre cinque anni vivendo di piccole rapine e svolgendo saltuariamente omicidi e furti per Joey Leone membro della famiglia mafiosa dei Leone. Nel 1992 la madre Beverly viene uccisa in un agguato dal gruppo dei Ballas, gang rivale della Grove Street Family, e CJ decide di far ritorno a casa per partecipare ai funerali.",1,"RG",16,2,"GTA_San_Andreas.jpg",1000,500),
("Battlefield 4",20.49,2013,"Differentemente da quanto accadeva nella campagna per giocatore singolo di Battlefield 3, in Battlefield 4 la storia si svolge seguendo quello che effettivamente è il vero ordine cronologico dei fatti narrati. Il protagonista è il sergente Recker, un marine statunitense, e la storia si svolge nel 2020, durante un conflitto immaginario tra gli Stati Uniti d'America, la Russia e la Cina.",1,"EA",12,3,"bf4.jpg",0,50),
("Battlefield 4 China Rising",2.99,2013,"The China Rising DLC for Battlefield 4 is set in China, as the name suggests. The DLC includes 4 brand new maps, new Chinese weapons, and new Chinese vehicles as well. In addition the DLC includes a bunch of new awards, dog tags, and other items.",0,"EA",12,3,"bf4.jpg",0,0),
("Battlefield 4 Naval Strike",3.50,2014,"Battlefield 4 Naval Strike includes four new, sea-based multiplayer maps, in addition to new weapons, vehicles, awards, and other features that each expansion pack includes. Naval Strike was first unveiled during GamesCom 2013. In addition to the new maps and vehicles, Naval Strike also includes the new Carrier Assault multiplayer game mode, which is a remake of the popular Titan game mode from BF2142.",0,"EA",12,3,"bf4.jpg",50,20),
("Battlefield 4 Propaganda",2.49,2014,"Battlefield 4 Propaganda is a multiplayer map that’s part of the Dragon’s Teeth expansion pack. The Propaganda map in Battlefield 4 is set in Pyongyang, North Korea. Propaganda features an interesting Levolution feature, which is a train that passes through the city, destroying and killing anything in its path.",0,"EA",12,3,"bf4.jpg",5,8),
("Age of Empires III: Age of Discovery",19.99,2005,"Differentemente da quanto accadeva nella campagna per giocatore singolo di Battlefield 3, in Battlefield 4 la storia si svolge seguendo quello che effettivamente è il vero ordine cronologico dei fatti narrati. Il protagonista è il sergente Recker, un marine statunitense, e la storia si svolge nel 2020, durante un conflitto immaginario tra gli Stati Uniti d'America, la Russia e la Cina.",1,"MS",12,5,"aoe3.jpg",30,120),
("Pro Evolution Soccer 2017",5.99,2017,"PES 2017 is the first game in the series that features Konami's new partnership with FC Barcelona. Premier League teams Arsenal F.C. and Liverpool are licensed, while Liverpool even entered into official partnership with Konami. However, PES 2017 no longer has some big teams that were licensed in PES 2016, most notably Real Madrid, Bayern Munich, Manchester United, Juventus and Porto.",1,"KO",3,6,"pes_2017.jpg",200,2000),
("Sonic the Hedgehog",4.30,2006,"La creazione del riccio blu nacque quando SEGA era alla ricerca di una nuova serie videoludica di punta per competere con la Nintendo, la cui serie di punta era ed è Mario, e per sostituire Alex Kidd, considerato la mascotte non ufficiale dell'azienda. Tra i vari design che vennero proposti figurarono un armadillo (che in seguito venne riutilizzato per lo sviluppo di Mighty the Armadillo), un cane, un sosia di Theodore Roosevelt in pigiama (che divenne la base del design di Eggman), e una lepre.Successivamente, Naoto Ōshima diede origine ad un riccio di colore verde acqua, inizialmente noto come Needlemouse, il quale venne scelto come personaggio rappresentativo.Gli sviluppatori dell'azienda ricolorarono il riccio in blu per marketing, per abbinare il colore a quello del logo SEGA, ispirandosi successivamente anche a dei personaggi reali, ad esempio per quanto riguarda le sue scarpe, le quali sono un design ispirato a stivali che Michael Jackson indossava nell'album del 1987 Bad; la sua personalità, l'atteggiamento e il tono di voce furono un omaggio al presidente degli Stati Uniti Bill Clinton anche se dal 1998 ad oggi sono molto cambiate.",1,"SE",12,2,"sonic.jpg",100,500),
("WWE 2k16",6.99,2016,"Reversals have been changed so players have a set amount of reversals per match, preventing players from spamming reversals all match.On next-gen versions, there are no loading screens between entrances, and players have the ability to attack other wrestlers during their entrance. Referee and manager AI has been improved.The chain wrestling minigame has been reworked.Pins and submissions have been reworked and improved, with a new system replacing the previous one, allowing for fairer breakouts and newer animations have also been added, including dirty pins and canceled pins.Online matchmaking has also been improved.The game will also feature rest holds characters can use to regain stamina.Gameplay in the PS3 and Xbox 360 versions remains largely the same blueprint as in previous iterations on those respective consoles However, New things have been introduced, though does include smoother animations for a number of moves. Handicap tag team and tornado tag matches, all of which were removed in WWE 2K15, return in WWE 2K16.",1,"T2",12,7,"wwe_2k16.jpg",50,20),
("DBZ: Budokai 3 ",34.49,2004,"Dragon Ball Z: Budokai 3, released as Dragon Ball Z 3 (ドラゴンボールZ3 Doragon Bōru Zetto Surī) in Japan, is a video game based on the popular anime series Dragon Ball Z and was developed by Dimps and published by Atari for the PlayStation 2. It was released on November 16, 2004, in North America in both a standard and Limited Edition release, the latter of which included a DVD featuring a behind the scenes looks at the game's development. In Europe, it was released on November 19, 2004.
The game's story mode yet again plays through the events of the Dragon Ball Z timeline, and the game includes several characters and events from the Dragon Ball Z movies (like Cooler, Broly and Bardock), Dragon Ball GT (like Super Saiyan 4 and Omega Shenron), and the original Dragon Ball series itself (Kid Goku). Players fly around a map of Earth and Namek, which changes depending on the Saga. Story Mode was originally intended to have storylines for every playable character in the game as proven by audio logs, but were cut down to just eleven characters, likely due to time constraints. Other features the game includes are a versus mode, an items shop, a tournament, and a battle ranking stage where the player has to challenge the AI in a hundred fighter challenge. Moving a spot above after beating who ever is next in the ranking. The fighting mechanics have also been enhanced from the preceding 2 games making the game closer to its anime counterpart in terms of combat (which was well received by fans of the series and gamers alike). Budokai 3 has a roster of 42 playable characters in recent releases of the game.",1,"BD",12,7,"dbz_3.jpg",30,60),
("Call of Duty: Ghosts",19.99,2013,"Call of Duty: Ghosts is a 2013 first-person shooter video game developed by Infinity Ward, with assistance from Raven Software, Neversoft and Certain Affinity. Published by Activision, it is the tenth primary installment in the Call of Duty series and the sixth developed by Infinity Ward. The video game was released for Microsoft Windows, PlayStation 3, Xbox 360, and Wii U on November 5, 2013, with Treyarch handling the port for the Wii U. The game was released with the launch of next-generation consoles PlayStation 4 and Xbox One and was the second and final Call of Duty game for the Wii U. On June 29, 2017, the Xbox 360 version was made compatible with the Xbox One.",1,"AC",16,3,"ghost.jpg",40,200),
("Assassin's Creed",15.99,2008,"Assassin's Creed is a franchise centered on an action-adventure video game series developed by Ubisoft. It depicts a centuries-old struggle pitting the Assassins, who fight for peace and free will, against the Templars, who believe peace comes through control of humanity. The series features historical fiction mixed with real-world historical events and figures. The series took inspiration from the novel Alamut by the Slovenian writer Vladimir Bartol, while building upon concepts from the Prince of Persia series.",1,"UB",16,1,"ac1.jpg",3,1000),
("Darksiders II",28.00,2012,"Players take control of Death, one of the Four Horsemen of the Apocalypse. The core gameplay is an action role-playing hack and slash style. The game makes frequent use of interactive puzzle elements, requiring the player to think their way through a series of levers, doors, elevators, portals, etc. in order to traverse areas and reach objectives.\nMaps are vast and each contain regions that can be explored freely on foot or by horse, along with numerous dungeons where quest objectives are generally carried out. There are main and side quests, with main and side boss fights. Worlds can be traversed via fast travel, whereby the player can teleport to certain map points instantly. While inside a dungeon, the player is allowed to fast travel back to the overworld while saving their dungeon location for continuation later without losing progress.",1,"TH",16,1,"dk2.jpg",5,0),
("Just Cause 2",25.00,2010,"Just Cause 2 is a third-person action-adventure game in which players control Rico Rodriguez, a major operative of the Agency, in an effort to overthrow the island dictatorship of Panau: an open world for players to explore. The game has three types of missions. Agency missions advance the story and are the game's main campaign; faction missions task players to assist the game's three factions, and stronghold missions task players to infiltrate government bases and liberate them for the factions. To advance through the campaign missions a player must earn chaos points, a progression system introduced in the game. Players earn chaos points for completing missions and destroying designated government property. As the number of chaos points increases, the factions gain influence and the government begins to collapse. In addition to typical missions, Just Cause 2 has race challenges which give players cash.",1,"SQ",18,1,"just_cause_2.jpg",20,30),
("F1 2017",15.00,2017,"The game features in-game commentary from David Croft and Anthony Davidson. The game also features an expanded team management mode, which offers players more control over research and development of car parts.Engine components and gearboxes are subject to wear and will ultimately fail, with players receiving grid penalties for exceeding their quota of components.",1,"CO",3,4,"f1_2017.jpg",100,50),
("DiRT Rally",5.00,2015,"Dirt Rally è un videogioco di guida focalizzato sul rally. I giocatori competono in stage a tempo nell'asfalto e nella terra in diverse condizioni atmosferiche.",1,"CO",3,4,"dirt.jpg",20,40),
("Rome: Total War",9.00,2004,"The player takes a role as the head of one of the three great Roman houses of the time; the Julii, Brutii, or Scipii. Over the course of the game new factions are unlocked, either one at a time as they are defeated, or all at once on completion of the campaign. Each faction has a different set of attributes, objectives, and initial provinces under its control. Control of a province is given to the faction whose army occupies the province's city. The ultimate goal is to become emperor by conquering fifty provinces, gaining support from the people, before capturing Rome itself, but a short game can be played in which you must control fifteen provinces and outlast certain faction(s).",1,"TW",7,5,"rome_tw.jpg",0,0),
("Tropico 5",18.65,2014,"There are a number of additions to the Tropico 5 game mechanics from the previous iteration of the series, notably the ability to advance to a new era if certain requirements are met; such as having written the constitution of Tropico. Tropico 5 includes 4 different eras, starting from Colonial Era, World Wars, Cold Wars and progressing up to Modern Times which allows progress from the 19th to the 21st century.",1,"HG",18,5,"tropico5.jpg",0,102),
("Half-Life",0.99,1998,"Half-Life is a first-person shooter that requires the player to perform combat tasks and puzzle solving to advance through the game. Unlike most of its peers at the time, Half-Life used scripted sequences, such as a Vortigaunt ramming down a door, to advance major plot points. Compared to most first-person shooters of the time, which relied on cut-scene intermissions to detail their plotlines, Half-Life's story is told mostly by means of scripted sequences, keeping the player in control of the first-person viewpoint. In line with this the player rarely loses the ability to control Gordon, who never speaks and is never actually seen in the game; the player sees through his eyes for the entire length of the game. Half-Life has no levels; it instead divides the game into chapters, whose titles flash on the screen as the player moves through the game. Progress through the world is continuous, except for short pauses for loading.",1,"VC",7,2,"hlife.jpg",1,1000),
("Street Fighter",2.50,1987,"Street Fighter, designed by Takashi Nishiyama and Hiroshi Matsumoto, made its debut in arcades, in 1987.In this game, the player takes control of martial artist Ryu, who competes in a worldwide martial arts tournament, spanning five countries and 10 opponents. A second player can join in at any time and take control of Ryu's American rival, Ken.",1,"CA",12,7,"sf.jpg",4,32),
("Street Fighter V", 50.00,2016,"Street Fighter V conserva il sistema di gioco dei suoi predecessori: due lottatori si sfidano nel tentativo di mandare al tappeto l'avversario attraverso l'uso di una varietà di colpi e attacchi speciali. In questo episodio viene reintrodotta la meccanica dell'EX Gauge presente in Street Fighter III: questa consiste in una barra che si riempie gradualmente man mano che gli attacchi vanno a segno e può essere spesa per potenziare gli attacchi speciali o per eseguire particolari combinazioni di attacchi chiamate Critical Arts.",1,"CA",12,7,"Street_figV.jpg",40,20),
("Toy Story 3: The Video Game",6.50,2010,"Woody, Jessie, Bullseye, Buzz Lightyear, Slinky, Rex, Hamm, the three squeaky toy aliens, Buttercup, the Peas-in-a-Pod, Mr. Pricklepants, Chuckles, Dolly and Trixie are the toys of a young girl named Bonnie Anderson. But among them, Woody, Jessie, Buzz, Slinky, Bullseye, Rex, Hamm and the alien toys used to belong to a boy named Andy Davis. Hamm, Rex and Slinky tell the original toys of Bonnie about an adventure they had before they went to Bonnie and how they ended up as Bonnie's.",1,"DI",3,2,"ts3.jpg",203,10),
("Ratchet & Clank: Nexus",55.00,2013,"The gameplay is just like the other games in the Ratchet & Clank series but more focuses on Gravity. The game features new weapons and gadgets as well as some returning ones, including the Fusion Grenade and The Warmonger. The game introduces new weapons as well, such as The Winterizer, which creates a tornado freezing enemies and turns them into snowmen, The OmniBlaster, a fast short range weapon and a Nightmare Box, a device that scares enemies, usually in forms of clowns, an eye or a pirate leaving Ratchet all sorts of weapons to eliminate them. Skill Points, Cheats and Gold Bolts make their return. Gadgets include The Repulsor, which suspends enemies in mid-air.",1,"SO",3,2,"rc_nexus.jpg",20,100),
("Dark Souls III",20.00,2016,"Nel regno di Lothric il suono di una campana preavvisa che l'Era del Fuoco sta terminando: la Prima Fiamma, ravvivata per la prima volta dal primo Signore dei Tizzoni, Lord Gwyn, è sul punto di spegnersi per sempre. In conseguenza di questo riappare la maledizione dei non morti e le ere spazio-temporali hanno iniziato a convergere tutte nello stesso punto: Lothric.",1,"NA",16,1,"dark_3.jpg",50,70),
("Tomb Raider: Underworld",3.50,2008,"In questo nuovo episodio, il mondo di Lara, diversamente dai precedenti, è un \"mondo interattivo che reagisce e ricorda\" Lara si sporca durante l'avventura, e la pioggia o una nuotata, possono sciacquare via lo sporco. I corpi dei nemici abbattuti rimangono nello stesso luogo dove Lara li ha uccisi. Ogni modifica o distruzione dell'ambiente sarà permanente.Secondo il direttore creativo Eric Lindstrom, ciò «non è dovuto solamente per ricompensare il giocatore dell'interazione che ha con l'ambiente, ma per fornirgli ulteriori indicazioni di percorso».",1,"EI",16,2,"Tomb-Raider.jpg",40,30);

#Transazione
INSERT INTO gamedb.transazione (cliente,importo,metodo,_data) VALUES
(3,10.00,"Gift card",'2016-01-18 00:00:00'),
(2,20.00,"Paypal",'2018-01-18 11:06:57'),
(4,10.00,"Mastercard",'2016-01-18 12:00:00'),
(1,500.00,"Visa",'2015-01-18 10:53:50');

#Traduzione
INSERT INTO gamedb.traduzione (prodotto, lingua) VALUES
(1,1),(1,2),(1,3),
(2,1),(2,2),(2,4),
(3,1),(3,3),
(4,4),(4,2),(4,5),
(5,3),(5,2),
(6,2),
(7,1),(7,2),(7,3),
(8,2),(8,3),(8,5),
(9,1),(9,2),(9,5),
(10,2),(10,3),
(11,2),
(12,2),(12,3),
(13,4),(13,2),
(14,2),
(15,2),(15,5),
(16,2),(16,4),
(17,1),(17,3),
(18,2),(18,3),(18,4),
(19,1),(19,2),(19,5),
(20,2),(20,5),
(21,2),(21,4),
(22,1),(22,3),
(23,2),
(24,2),(24,3),
(25,1),(25,2),
(26,1),(26,3);

#Acquisto
INSERT INTO gamedb.acquisto VALUES
(1, 1, "2018-01-27 15:44:42", 3775, 0.30),
(1, 2, "2018-01-27 15:49:38", 1119, 5.99),
(2, 10, "2017-01-27 15:20:38", 1230, 3.99),
(3,26,"2015-02-28 07:20:05",1000,4.99);

#Aggiorna copie vendute
UPDATE gamedb.prodotto SET copie_disponibili=copie_disponibili-1, copie_vendute=copie_vendute+1 WHERE cod_prodotto=1;
UPDATE gamedb.prodotto SET copie_disponibili=copie_disponibili-1, copie_vendute=copie_vendute+1 WHERE cod_prodotto=2;
UPDATE gamedb.prodotto SET copie_disponibili=copie_disponibili-1, copie_vendute=copie_vendute+1 WHERE cod_prodotto=10;
UPDATE gamedb.prodotto SET copie_disponibili=copie_disponibili-1, copie_vendute=copie_vendute+1 WHERE cod_prodotto=26;




