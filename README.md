Tkacz Jessica | Tomasz Wilk 
 --------------- | ----------------
 jessicatkacz@wp.pl | Wilczyy@gmail.com

<p align="center">UNIWERSYTET GDAŃSKI</p>

<p align="center">WYDZIAŁ MATEMATYKI, FIZYKI I INFORMATYKI</p>

**<p align="center">Jessica Tkacz</p>**

**<p align="center">Tomasz Wilk</p>**

<p align="center"><b>Kierunek</b>: Informatyka</p>

<p align="center"><b>Specjalność</b>: Aplikacje internetowe i bazy danych</p>

<p align="center">Aplikacja dla systemu Android usprawniająca kontakty z bliskimi.</p>

<p align="right">Praca licencjacka napisana</p>

<p align="right">pod kierunkiem dr Włodzimierza Bzyla</p>

<p align="center">Gdańsk 2016</p>

SŁOWA KLUCZOWE:
„aplikacja” „Android” ”rodzina” „przypomnienia” „prostota” „adnotacje” „notyfikacje” „kontakt” „organizacja” „oszczędność czasu” „zadzwonić”  „telefon” „systematyczność” „połączenie”

### Spis treści  
<br/>1. [Streszczenie](#Streszczenie) 
<br/>
<br/>2. [Wstep](#Wstep)
<br/>
<br/>3. [Analiza problemu](#Opis)  sam tytuł zostaje
<br/>3.1. [Porównanie dostępnych rozwiązań](#Porownanie)
<br/>3.2. [Możliwości zastosowania praktycznego](#Mozliwosci) nie wiem czy ten punkt nam wgl potrzebny
<br/>
<br/>4. [Wymagania funkcjonalne i niefunkcjonalne](#Wymagania)
<br/>4.1. Wymagania funkcjonalne
<br/>4.2. Wymagania niefunkcjonalne
<br/>
<br/>5. [Projekt systemu](#projekt)
<br/>5.1. Architektura rozwiązania - sam tytuł zostaje
<br/>5.1.1 Aktorzy i przypadki użycia --> DIAGRAMY I TAKIE TAM NA GWAŁT!!!!!!!
<br/>5.1.2 Diagram klas -II-
<br/>5.1.3 Diagram modelu danych -II-
<br/>5.2. Projekt interfejsu użytkownika V
<br/>5.3. Funkcjonalności - fragmenty kodu aplikacji - jak bd czas to można doopisać
<br/>5.4. Użyte technologie  - gadka o użytych technologiach, wytłumaczenie konkretnych zagadnień
<br/>5.5. [Testowanie aplikacji](#Testowanie) - rozpisaać WILU
<br/>
<br/>6. [Podział pracy nad projektem](#Wklad)
<br/>6.1. Jessica Tkacz
<br/>6.2. Tomasz Wilk
<br/>
<br/>7. [Podsumowanie](#podsumowanie) JESS
<br/>
<br/>8. [Bibliografia](#Bibliografia) jak tu dotrzemy to umrzemy ze szczęścia <3
<br/>
<br/>9. [Załączone źródła](#potoki)



<a name="Streszczenie"/>
## 1. Streszczenie
<p>Jako pracę licencjacką stworzyliśmy aplikację dla systemu Android o nazwie RemembrCall, której zadaniem jest przypominać użytkownikowi o wykonaniu telefonu do wybranego kontaktu. Naszym podstawowym celem jest wspomóc zapominalską lub zapracowaną osobę w relacjach z rodziną. Pomysł powstał na podstawie własnych doświadczeń oraz w wyniku braku satysfakcjonującego nas rozwiązania na rynku.
</p>
<p>
Nazwa aplikacji dość bezpośrednio wskazuje na jej funkcjonalność, lecz kryje się w niej również nawiązanie do dobrze większości ludzi znanej sagi o Harrym Potterze. Kolega Harry,ego, Neville, był bardzo zapominalskim chłopcem, dlatego babcia przysłała mu Przypominajkę (ang. Remembrall), która zmieniała kolor za każdym razem, kiedy Neville o czymś zapomniał. Nasza aplikacja RemembrCall jest więc kombinacją angielskiej nazwy Przypominajki oraz Call (dzwonić), co niebanalnie wskazuje sposób na jej zastosowanie.
</p>
<p>
Ze względu na fakt, iż na rynku smartfonów królują w większości te zasilane systemem Android, co bezpośrednio przekłada się na liczbę odbiorców, zdecydowaliśmy się stworzyć naszą aplikację właśnie dla tego systemu.  Dokonaliśmy tego z wykorzystaniem środowiska Android Studio, posługując się językiem programowania Java. Wersja załączona do pracy operuje na systemie minutowym i w takiej postaci była również testowana, natomiast w oficjalnej wersji zamiast minut wprowadziliśmy dni.
</p>
<p>
W czasach, gdzie praktycznie każdy ma do dyspozycji smartfona bardzo zależało nam, by nasza aplikacja była prosta w obsłudze, żeby mogły z niej korzystać osoby w różnym wieku. Z tego powodu stworzony interfejs jest przejrzysty i nieskomplikowany, tak by nie nastręczał problemów osobie mało obeznanej z coraz to nowszymi technologiami. Naszym zamysłem było, by od strony użytkownika aplikacja była mało wymagająca, dlatego właściwie jedyną czynnością, jaką musi on wykonać to wybrać częstotliwość połączeń z wybranym kontaktem. Doszliśmy również do wniosku, że nie chcemy tworzyć kolejnej aplikacji z niepotrzebnymi funkcjami i częstymi aktualizacjami, które wzbudzają jedynie irytację, gdyż takich jest na rynku do wyboru aż nadmiar. Nasza RemembrCall spełnia swe zadanie i działa tak jak powinna, a przy tym nie wymaga wiele czasu ani specjalnych umiejętności.
</p>

<a name="Wstep"/>
## 2. Wstęp
<p>
Wartości rodzinne i ogólnie międzyludzkie są jednymi z najważniejszych dla każdego człowieka. W obecnych czasach mamy bardzo rozwiniętą sieć komunikacji, nie musimy pisać listów i czekać tygodniami na odpowiedź. Wystarczy sięgnąć po telefon bądź komunikator internetowy i możemy porozmawiać nawet twarzą w twarz z osoba będącą w dowolnym miejscu na świecie. Paradoksalnie urządzenia, które miały pomóc w tym kontakcie coraz częściej oferują inne zastosowania, pochłaniające czas i kierujące myśli na inne tory, także często okazuje się, że zapominamy o tym, co najważniejsze. Również z większą ilością obowiązków, pracą, zatracamy lub tłumimy tę potrzebę kontaktu z najbliższymi. Bardzo wielu młodych ludzi zapomina jak ważne są rozmowy czy spotkania dla starszego pokolenia. Tymczasem wystarczy raz na tydzień czy dwa zadzwonić do babci, by była szczęśliwa. Dzięki temu i ta młoda osoba, która być może na razie nie widzi takiej potrzeby, na przyszłość nie będzie żałowała zaniedbywania tej sfery życia. Inaczej w efekcie nadchodzi moment, kiedy człowieka nachodzi refleksja, że chciałby to zmienić,a czasem bywa za późno.
</p>
<p>
Powodem, dla którego podjęliśmy ten temat jest fakt, iż sami znajdujemy się w grupie potencjalnych odbiorców. Po sobie jaki i po naszych kolegach widzimy, iż relacje rodzinne ulegają stopniowo rozluźnieniu. Jest to problem zwłaszcza teraz, w czasach, gdy ludzie są rozpraszani wieloma innymi zajęciami. Zdarza się, że rodzice muszą prosić dorosłe dziecko by zadzwoniło do dziadków, żeby nie było im przykro, co jest żenujące dla obu stron. A przecież to wcale nie jest tak, że nie chcemy albo nas to nie obchodzi. Zwyczajnie ta sprawa zanika wśród wielu innych, zapomina się, przekłada na później.Stworzona przez nas aplikacja RemembrCall ma na celu wspomóc pielęgnowanie więzi poprzez choćby cotygodniową rozmowę.
</p>
<p>
Istnieją oczywiście aplikacje dla systemu Android, które choć po części miały spełniać podobną rolę, ale posiadały one zazwyczaj zbyt wiele skomplikowanych ustawień oraz niepotrzebnych funkcji, do których po krótkim czasie traciło się cierpliwość. Ponadto aplikacja wszystkim swoim użytkownikom wysyła adnotacje z przypomnieniem o np. Dniu Dziadka albo Dniu Matki, co jest ponadprogramową okazją do wykonania telefonu.
</p>	
##3.  Analiza problemu

<a name="Porownanie"/>
###	3.1. Porównanie dostępnych rozwiązań
Analiza dostępnych rozwiązań rozpoczęła się na długo przed podjęciem decyzji o pisaniu naszej aplikacji, jako że szukaliśmy czegoś podobnego do własnego użytku.

####3.1.1. Call Reminder (Duckbone Apps)- aplikacja dostępna w Sklepie Play na platformę Android. Nazwa sugeruje funkcjonalność zbliżoną do RemembrCall.

Podobieństwa:
Jest możliwość ustawienia przypomnienia o wykonaniu telefonu do konkretnego numeru o konkretnej godzinie, można również ustawić częstotliwość przypomnienia najrzadziej na co tydzień. 

Różnice:
Oprócz przypomnieniu o telefonie dostępne jest również przypomnienie o wysłaniu sms’a, maila, dodanie notatki. Występuje konieczność częstego powracania do ustawień. W przeciwieństwie do RemembrCall brak możliwości obsługi w języku polskim. Interfejs oraz sposób dokonywania ustawień bardziej złożone i kłopotliwe dla starszych i mniej zorientowanych technologicznie odbiorców. Wymaga nadania większej ilości uprawnień.

####3.1.2. Call Reminder (AppAspect Technologies Pvt. Ltd.) - kolejna aplikacja o tej samej nazwie, również przeznaczona dla użytkowników systemu Android.

Podobieństwa:
Głównym zadaniem obu aplikacji jest przypomnienie użytkownikowi o wykonaniu telefonu. Obie również mają możliwość wyboru częstotliwości połączeń

Różnice:
Trzeba manualnie wprowadzić numer oraz nazwę kontaktu, można wybrać godzinę przypomnienia oraz częstotliwość przypomnień nawet raz na rok. Do wyboru również przypomnienie o wysłaniu sms’a oraz możliwość zrobienia notatki. Aplikacja niepotrzebnie wyświetla u siebie spis połączeń oraz książkę kontaktów. Call Reminder dokonuje przypomnienia w sposób dość inwazyjny tj. wyświetla powiadomienie na środku ekranu wydając przy tym irytujący dźwięk, trzeba zadzwonić natychmiast albo przypomnienie się usuwa. RemembrCall wysyła przypomnienie dyskretnie i pozostaje na górze ekranu do czasu, aż użytkownik zdecyduje się je wybrać.
	

<a name="Mozliwosci"/>
### 	3.2. Możliwości zastosowania praktycznego
Aplikacja ma na celu wspomóc osoby, które z różnych powodów nie pamiętają o wykonaniu telefonu do bliskich osób, choć ważne jest dla nich utrzymywanie dobrych stosunków z nimi oraz regularny kontakt. Naszym celem było by prosty w obsłudze interfejs oraz jednorazowa konieczność tworzenia ustawień sprawiły by aplikacja mogła cieszyć się popularnością wśród różnych grup wiekowych. Nasze rozwiązanie może posłużyć zarówno młodzieży, która przez nawał obowiązków nie zawsze pamięta o tym, żeby zadzwonić do ukochanej babci, jak i również osobom starszym w kontaktach z rodziną czy w przypadku regularnych wizyt u lekarza wymagających rejestracji. Ponadto aplikacja może zostać wykorzystana przez  specjalistów różnych dziedzin jako wsparcie w kontakcie z klientami w regularnych odstępach czasu (np. comiesięczne przypomnienie o wizycie ortodontycznej). 
2. Projekt i analiza

W TYM ROZDZIALE PRAGNIEMY PRZEDSTAWIĆ WYBRANE DIAGRAMY ZWIĄZANE ZE SPOSOBEM DZIAŁANIA NASZEJ APLIKACJI, JEJ STRUKTURĄ ORAZ SAMYM JEJ ZAPROJEKTOWANIEM. wtf? : D
    





<a name="Wymagania"/>
## 4.  Wymagania funkcjonalne i niefunkcjonalne

###	4.1. Wymagania funkcjonalne:
Aplikacja pobiera pełną listę kontaktów z telefonu użytkownika i wyświetla ją wraz z opcjami ustawień. Właściciel ustawia pożądaną częstotliwość przypomnień o połączeniu z danym kontaktem za pomocą seekBar, a obok prezentują się rezultaty wykonanych czynności w postaci ilości dni. Następnie wstępnie zapisuje te ustawienia za pomocą checkBox, ponieważ tylko zaznaczone w ten sposób kontakty zostaną uwzględnione przez aplikację. Jest to zabezpieczenie na wypadek, gdyby użytkownik przypadkiem ustalił priorytet w kontakcie, na temat którego powiadomień nie chce otrzymywać. Na sam koniec wystarczy potwierdzić wszystkie ustawienia za pomocą guzika na dole, co da aplikacji ostateczną wersję, którą ma wziąć pod uwagę. W każdym momencie użytkownik może powrócić do owych ustawień i je zmienić.



###	4.2. Wymagania niefunkcjonalne:
Oczywistym ograniczeniem jest fakt, iż aplikacja jest zorientowana na system Android i na żadnym innym nie będzie działała. Możliwe jest używanie jej zarówno na smartfonach, jak i tabletach posiadających wersję systemu Android 5.0. i wzwyż.
Można również uruchomić aplikację w środowisku Android Studio, w którym była pisana i oglądać efekty próbnych działań na wybranym emulatorze posiadającym odpowiednią wersję systemu. 


<a name="projekt"/>
## 5. Projekt systemu
###5.1. Architektura rozwiązania
####5.1.1. Aktorzy i przypadki użycia
####5.1.2. Diagram klas
####5.1.3. Diagram modelu danych albo encji



### 	5.2. Projekt interfejsu użytkownika

Strona główna po uruchomieniu aplikacji RemembrCall. Wyświetlają się tutaj wszystkie kontakty pobrane z telefonu. Do każdego kontaktu widzianego
w osobnej ramce mamy opcje wyboru częstotliwości połączeń oraz pole do zaznaczenia aby ustawienia zostały wzięte pod uwagę. Na dole po prawej stronie widnieje przycisk „Zapisz”, którego wciśnięcie jest konieczne do działania aplikacji. Na samej górze znajduje się krótki opis korzystania z niej.
<img src="ss1.png" width="40%" height="40%" />
======
Przykładowy widok notyfikacji przypominających o wykonaniu telefonu do konkretnej osoby, wysłanych po wybranym przez użytkownika czasie. Adnotacja przybiera kształt spacerującej o lasce staruszki, co nawiązuje tematycznie do ikony całej aplikacji.
<img src="ss2.png" width="40%" height="40%" />
======
Po rozwinięciu czarnego paska u góry pokazują się szczegóły poszczególnych notyfikacji takie jak nazwa kontaktu oraz ilość dni, które minęły od ostatniego połączenia z nim.
<img src="ss3.png" width="40%" height="40%" />
======
Po kliknięciu konkretnej adnotacji aplikacja przekierowuje użytkownika bezpośrednio do Książki telefonicznej z już wybranym numerem kontaktu, odnośnie którego notyfikację wybraliśmy. Jest to o tyle komfortowe, że dopóki nie klikniemy adnotacji, będzie nam ona wciąż przypominała o tym, żeby zadzwonić, a gdy zostanie już wybrana poniekąd zmusi użytkownika do wykonania zaplanowanego telefonu.
<img src="ss4.png" width="40%" height="40%" />
======


 
### 	5.3. Funkcjonalności - fragmenty kodu aplikacji

a) Funkcja setContactCalls odpowiedzialna jest za dopasowanie połączeń do konkretnych kontaktów:
```java

            while (!phone.isAfterLast()) {
            
		...

                Call recentCall = new Call();
                if(calls != null) {
                    for (Call c : calls){
                        if(Integer.parseInt(c.getDuration()) > 0){
                            if(c.getDate().compareTo(recentCall.getDate())>0){
                                recentCall = c;
                            }
                        }
                    }
                }

                if (contact == null) {
                    continue;
                }

                contact.setRecentCall(recentCall);

            }

```

b) Funkcja CallNotification odpowiedzialna za pokazanie pojedynczej notyfikacji:
```java
 public class CallNotification {
	...
    }

    public void showNotification(String message, String tittle, Context context, int id, String phoneNumber) {
	...

        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.babcia)
                .setContentTitle(tittle)
                .setContentText(message)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) 
        notificationManager.notify(id, notification);
    }

}
```

c) Główna funkcja odpowiedzialna za wybieranie kontaktów nadających się do wysłania notyfikacji:
```java
                if(c.isChecked()){
                    Log.i("longCall", c.name + " " + c.delay + " od ostatniej rozmowy "+ (c.getProgression()*(1000)));
                    String tittle = "zadzwon do " + c.getName();
                    String message = "Dzwoniles dawniej niz "+ c.getProgression() + " minut temu";
                    String number = "" ;
                    if (c.numbers.size() > 0 && c.numbers.get(0) != null) {
                        number = c.numbers.get(0).number;
                    }

                    if(c.getDelay() > c.getProgression()*(1000*60)){
                        Log.i("longCall", message);
                        new AlarmBroadcaster(context,tittle , message, number, c.id).setAlarmBroadcast(0);
                    } else {
                        Log.i("longCall", "dzwoniles do " + c.name + " zadzwon za " + (c.getProgression()-(c.getDelay()/(1000*60))));
                        new AlarmBroadcaster(context, tittle, message,number, c.id)
                                .setAlarmBroadcast((int) (c.getProgression()-(c.getDelay()/(1000*60))));
                    }

                } else {
                    new AlarmBroadcaster(context).cancelAlarm(c.id);

                }
```

d) Klasa odpowiedzialna za tworzenie alarmów systemowych, które po danym czasie wywołają funkcje wyświetlającą notyfikacje. + możliwość anulowania zakolejkowanych notyfikacji:
```java
    public class AlarmBroadcaster {
	...
	
        public AlarmBroadcaster(Context context, String tittle, String message, String phoneNumber, String id) {
		...
            reminderBroadcastIntent = PendingIntent.getBroadcast(context, Integer.parseInt(id), intent, PendingIntent.FLAG_UPDATE_CURRENT);

        }

        public void setAlarmBroadcast(int minutes){
		...
            alarmToBroadcast.set(AlarmManager.RTC_WAKEUP, when, reminderBroadcastIntent);
        }
        public void cancelAlarm(String id){
		...
            alarmToCancel.cancel(pendingIntentToCancel);
        }
    }
}
```


e) Funkcja tworząca mapę połączeń przypisanych do numeru na podstawie historii połączeń telefonu.
```java
 public void getCallDetails(Context context) {
	...

        while (callDetailsCursor.moveToNext()) {
		...


            if(callsMap.get(phNumber) != null)
            {
                ArrayList<Call> calls = callsMap.get(phNumber);
                calls.add(new Call(callDateTime, callDuration, contactName));
                callsMap.put(phNumber, calls);

            } else {
                ArrayList<Call> calls = new ArrayList<>();
                calls.add(new Call(callDateTime, callDuration, contactName));
                callsMap.put(phNumber, calls);
            }

        }
}
```

### 5.4 Użyte technologie

Aplikacja została napisana w języku programowania Java w środowisku Android Studio w wersji 2.1.. Aplikacja zaprogramowana została z myślą o użytkownikach systemu Android 5.0. bądź późniejszym. Program kompilowany był dla wersji Android API 21., a buildowany dokładnie dla wersji 21.1.2. poprzez gradle 2.1. Odbiór zewnętrznych wiadomości został zrealizowany przez GCM (ang. Google Cloud Messages) przy pomocy pushbots w wersji 2.0.13.. Front-end występuje w postaci plików xml (ang. Extensible Markup Language) w wersji 1.0. z kodowaniem UTF-8.

<a name="Testowanie"/>
### 5.5 Testowanie aplikacji
	Testowanie aplikacji przeprowadzono manualnie wykonując wybrane operacje w aplikacji.
	
<a name="Wklad"/>
##6. Podział pracy nad projektem

Określenie indywidualnego wkładu w pracę każdego z członków zespołu:
###	6.1. Tkacz Jessica: 
	* wczytywanie ustawień dla kontaktów,
	* strona wizualna aplikacji (front-end oraz widoki),
	* modele kontaktów,
	* pobieranie rejestru połączeń, 
	* dokumentacja

###	6.2. Wilk Tomasz: 
	* zapisaniem ustawień dla kontaktów,
	* pobieranie kontaktów z urządzenia, 
	* zarządzaniem notyfikacjami, 
	* mechanizm opóźniający, 
	* zarządzanie broadcasterem, 
	* testowanie aplikacji

<a name="podsumowanie"/>
##7. Podsumowanie

<a name="Bibliografia"/>
##8. Bibliografia

<a name="potoki"/>
##9. Załączone źródła
