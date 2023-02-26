/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.stream.Stream;
import org.heigit.ohsome.oshdb.OSHDBBoundingBox;
import org.heigit.ohsome.oshdb.OSHDBTag;
import org.heigit.ohsome.oshdb.OSHDBTags;
import org.heigit.ohsome.oshdb.OSHDBTimestamp;
import org.heigit.ohsome.oshdb.api.db.OSHDBDatabase;
import org.heigit.ohsome.oshdb.api.db.OSHDBH2;
import org.heigit.ohsome.oshdb.api.mapreducer.MapReducer;
import org.heigit.ohsome.oshdb.api.mapreducer.OSMContributionView;
import org.heigit.ohsome.oshdb.api.mapreducer.OSMEntitySnapshotView;
import org.heigit.ohsome.oshdb.osm.OSMEntity;
import org.heigit.ohsome.oshdb.osm.OSMType;
import org.heigit.ohsome.oshdb.util.celliterator.ContributionType;
import org.heigit.ohsome.oshdb.util.function.SerializableBinaryOperator;
import org.heigit.ohsome.oshdb.util.function.SerializableFunction;
import org.heigit.ohsome.oshdb.util.function.SerializablePredicate;
import org.heigit.ohsome.oshdb.util.function.SerializableSupplier;
import org.heigit.ohsome.oshdb.util.geometry.Geo;
import org.heigit.ohsome.oshdb.util.mappable.OSMContribution;
import org.heigit.ohsome.oshdb.util.mappable.OSMEntitySnapshot;
import org.heigit.ohsome.oshdb.util.tagtranslator.TagTranslator;
import org.heigit.ohsome.oshdb.util.time.OSHDBTimestamps;
import org.heigit.ohsome.oshdb.util.time.OSHDBTimestamps.Interval;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author spravce
 */
public class Mavenproject1 {

    
//    //DOTAZ NA STAV OSM    
//    //Snapshot s jedním timestamp
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Integer result = OSMEntitySnapshotView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2021-01-01")
//            .filter("type:way and building=*")
//            .count();
//        System.out.println(result);
//        System.out.println("Diggy diggy hole!");
//    }
    
    

//    //snapshot s více timestamps - počet prvků na základě filtru - Nelze použít funkci Geo
//    //aggregateByTimestamp - není použito groupByEntity
//    
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        SortedMap<OSHDBTimestamp, List<OSMEntitySnapshot>> result = OSMEntitySnapshotView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01", "2021-01-01", Interval.YEARLY)
////            .filter("(leisure=park and geometry:polygon) or (amenity=bench and (geometry:point or geometry:line))")  //přednost ve filtrech se řeší závorkami
////            .filter("(type:way and highway in (motorway, motorway_link, trunk, trunk_link, primary, primary_link, secondary, secondary_link, tertiary, tertiary_link, unclassified, residential) or (highway=service and service=alley))") //hodnota náleží do množiny
//            .filter("type:way and highway=residential and name!=* and noname!=yes")  //přednost ve filtrech se řeší závorkami    //závorky nejsou vlastně nutné, tento příkaz je pro kontrolu kvality dat - chybějících atributů
//            .aggregateByTimestamp() //vytvori Mapu podle timestampu
////            .count();
//            .collect(); //vraci list snapshotu pro jednotlive objekty
//        
//        int i=0;
//        for (Map.Entry mapElement : result.entrySet()){      //for each loop - pro každý timestamp...
//            i=i+1;
//            OSHDBTimestamp key = (OSHDBTimestamp) mapElement.getKey();
//            System.out.print(i+" timestamp: "+key+" ");
//            List<OSMEntitySnapshot> list = (List<OSMEntitySnapshot>) mapElement.getValue(); //...získej seznam prvků OSM
//
//            int j=0;
//            for (OSMEntitySnapshot snapshot : list){             //for each loop - pro každý prvek OSM...
//                j=j+1;
//                OSMType type=snapshot.getEntity().getType();    //zjistit její geometrii
//                OSHDBTags tags=snapshot.getEntity().getTags();  //a atributy. Místo tagů vrací čísla???
//                System.out.print(j+". entita: "+type+" ");
//
//                
//                tags.forEach(System.out::println); //cely nasledujici cyklus se da nahradit jednim radkem - Double colon operator
//                
//                tags.forEach( (n) -> { System.out.println(n); } ); //nebo takto - Lambda expression
//                               
////                int k=0;
////                int tagKey=0;
////                int tagValue=0;
////                                
////                for (OSHDBTag tag : tags){
////                    k=k+1;
////                    tagKey=tag.getKey(); //vraci jen cisla
////                    tagValue=tag.getValue();
//////                        TagTranslator.getOSMRoleOf(tagKey); //tady by se muselo definovat spojeni do DB, kde jsou keytables kodujici cisla do tagu
////                    System.out.print(k+". tag: "+tagKey+"="+tagValue+" ");        
////                }
//                
//                
//            }            
//        }
//        System.out.println("Diggy diggy hole!");
//    }
   

    
    
    
//    //SOUVISLOST MEZI groupByEntity a aggregateByTimestamp
//    
//    //snapshot s více timestamps - počet prvků na základě filtru - Nelze použít funkci Geo
//    //NENÍ použito groupByEntity a NENÍ použito aggregateByTimestamp
//    //seskupi changesety jednotlivych entit a seřadí je podle timestampu od nejstaršího k nejnovějšímu - I BEZ groupByEntity a BEZ aggregateByTimestamp!!!
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        List<OSMEntitySnapshot> result = OSMEntitySnapshotView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01", "2021-01-01", Interval.YEARLY)
////            .filter("(leisure=park and geometry:polygon) or (amenity=bench and (geometry:point or geometry:line))")  //přednost ve filtrech se řeší závorkami
////            .filter("(type:way and highway in (motorway, motorway_link, trunk, trunk_link, primary, primary_link, secondary, secondary_link, tertiary, tertiary_link, unclassified, residential) or (highway=service and service=alley))") //hodnota náleží do množiny
//            .filter("type:way and highway=residential and name!=* and noname!=yes")  //přednost ve filtrech se řeší závorkami    //závorky nejsou vlastně nutné, tento příkaz je pro kontrolu kvality dat - chybějících atributů
////            .count();
//            .collect(); //vraci list snapshotu pro jednotlive objekty. 
//        System.out.println("size: "+result.size()); 
//    
//        int j=0;
//        for (OSMEntitySnapshot snapshot : result){             //for each loop - pro každý snapshot prvku OSM
//            j=j+1;
//            long entita=snapshot.getEntity().getId();    //zjistit její geometrii
//            OSHDBTimestamp timestamp = snapshot.getTimestamp();
//            OSHDBTags tags=snapshot.getEntity().getTags();  //a atributy. Místo tagů vrací čísla???
//            System.out.print("pruchod: "+j+" entita: "+entita+" timestamp: "+timestamp+" ");
//
//            int k=0;
//            for (OSHDBTag tag : tags){                  //vypise jednotlive tagy
//                k=k+1;
//                int tagKey=tag.getKey(); //vraci jen cisla
//                int tagValue=tag.getValue();
////                        TagTranslator.getOSMRoleOf(tagKey); //tady by se muselo definovat spojeni do DB, kde jsou keytables kodujici cisla do tagu
//                System.out.print(k+". tag: "+tagKey+"="+tagValue+" ");        
//            }
//        }            
//        System.out.println("Diggy diggy hole!");
//    }

    
    
//    //snapshot s více timestamps - počet prvků na základě filtru - Nelze použít funkci Geo
//    //JE použito groupByEntity a NENÍ použito aggregateByTimestamp
//    //seřazeno podle prvku OSM a podle timestamp
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Set<List<OSMEntitySnapshot>> result = OSMEntitySnapshotView.on(oshdb)
//            .groupByEntity() //vše seskupí snapshoty jednotlivych OSM prvků - postupne podle timestampu
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01", "2021-01-01", Interval.YEARLY)
////            .filter("(leisure=park and geometry:polygon) or (amenity=bench and (geometry:point or geometry:line))")  //přednost ve filtrech se řeší závorkami
////            .filter("(type:way and highway in (motorway, motorway_link, trunk, trunk_link, primary, primary_link, secondary, secondary_link, tertiary, tertiary_link, unclassified, residential) or (highway=service and service=alley))") //hodnota náleží do množiny
//            .filter("type:way and highway=residential and name!=* and noname!=yes")  //přednost ve filtrech se řeší závorkami    //závorky nejsou vlastně nutné, tento příkaz je pro kontrolu kvality dat - chybějících atributů
////            .count();
//            .uniq(); //vraci list snapshotu pro jednotlive objekty. 
//        System.out.println("size: "+result.size()); 
//    
//        int i=0;
//        for (List<OSMEntitySnapshot> snapshotList : result){      //for each loop - pro každý prvek OSM...
//            i=i+1;
//            System.out.print("i: "+i+" ");
//
//            int j=0;
//            for (OSMEntitySnapshot snapshot : snapshotList){             //for each loop - pro každý snapshot prvku OSM
//                j=j+1;
//                System.out.print("j: "+j+" ");
//                long entita=snapshot.getEntity().getId();    
//                OSHDBTimestamp timestamp = snapshot.getTimestamp();
//                OSHDBTags tags=snapshot.getEntity().getTags();  //a atributy. Místo tagů vrací čísla???
//                System.out.print(" entita: "+entita+" timestamp: "+timestamp+" ");
//
//                int k=0;
//                for (OSHDBTag tag : tags){                  //vypise jednotlive tagy
//                    k=k+1;
//                int tagKey=tag.getKey(); //vraci jen cisla
//                int tagValue=tag.getValue();
////                        TagTranslator.getOSMRoleOf(tagKey); //tady by se muselo definovat spojeni do DB, kde jsou keytables kodujici cisla do tagu
//                    System.out.print(k+". tag: "+tagKey+"="+tagValue+" ");        
//                }
//            }            
//        }
//        System.out.println("Diggy diggy hole!");
//    }



    //snapshot s více timestamps - počet prvků na základě filtru - Nelze použít funkci Geo
    //NENÍ použito groupByEntity a JE použito aggregateByTimestamp
    //seřazeno podle timestamp a podle prvku OSM
    public static void main(String[] args) throws Exception {
        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
        SortedMap<OSHDBTimestamp,List<OSMEntitySnapshot>> result = OSMEntitySnapshotView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
            .timestamps("2020-01-01", "2021-01-01", Interval.YEARLY)
//            .filter("(leisure=park and geometry:polygon) or (amenity=bench and (geometry:point or geometry:line))")  //přednost ve filtrech se řeší závorkami
//            .filter("(type:way and highway in (motorway, motorway_link, trunk, trunk_link, primary, primary_link, secondary, secondary_link, tertiary, tertiary_link, unclassified, residential) or (highway=service and service=alley))") //hodnota náleží do množiny
            .filter("type:way and highway=residential and name!=* and noname!=yes")  //přednost ve filtrech se řeší závorkami    //závorky nejsou vlastně nutné, tento příkaz je pro kontrolu kvality dat - chybějících atributů
            .aggregateByTimestamp()                                               //vytvori Mapu podle timestampu
//            .count();
            .collect(); //vraci list snapshotu pro jednotlive objekty. 
        System.out.println("size: "+result.size()); 
    
        int i=0;
        for (Map.Entry mapElement : result.entrySet()){      //for each loop - pro každý timestamp...
            i=i+1;
            OSHDBTimestamp timestamp = (OSHDBTimestamp) mapElement.getKey();
            System.out.print(i+" timestamp: "+timestamp+" ");
            List<OSMEntitySnapshot> snapshotList = (List<OSMEntitySnapshot>) mapElement.getValue(); //...získej list snapshotů

            int j=0;
            for (OSMEntitySnapshot snapshot : snapshotList){             //for each loop - pro každý snapshot prvku OSM
                j=j+1;
                System.out.print("j: "+j+" ");
                long entita=snapshot.getEntity().getId();   
                System.out.print(" entita: "+entita+" ");
                OSHDBTags tags=snapshot.getEntity().getTags();  //a atributy. Místo tagů vrací čísla???

                int k=0;
                for (OSHDBTag tag : tags){                  //vypise jednotlive tagy
                    k=k+1;
                int tagKey=tag.getKey(); //vraci jen cisla
                int tagValue=tag.getValue();
//                        TagTranslator.getOSMRoleOf(tagKey); //tady by se muselo definovat spojeni do DB, kde jsou keytables kodujici cisla do tagu
                    System.out.print(k+". tag: "+tagKey+"="+tagValue+" ");        
                }
            }            
        }
        System.out.println("Diggy diggy hole!");
    }


    
    
    
    
//    //Funkce Geo
//    //Snapshot s více timestamps - suma plochy - funkce Geo. Vysledek se prochazi dvojitym cyklem. Dva druhy filtrace a použití geometrie neoříznuté Bounding Boxem.
//    public static void main(String[] args) throws Exception {
////        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/mittelfranken.oshdb.mv.db"); //verze souboru pro starou verzi oshdb nefunguje
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        SortedMap<OSHDBTimestamp, List<Double>> result = OSMEntitySnapshotView.on(oshdb) //Musí být Number
////            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2015-01-01", "2016-01-01", Interval.YEARLY)
//            .filter("type:way and building=hotel")                                //Filtrace v rámci OSHDB filter
//            .map(snapshot -> Geo.areaOf(snapshot.getGeometryUnclipped())) //Místo standardní getGeometry() je použita geometrie neoříznutá BoundingBoxem
////            .map(snapshot -> Geo.areaOf(snapshot.getGeometry())) //Místo standardní getGeometry() je použita geometrie neoříznutá BoundingBoxem
//                
////            .filter(area -> area < 1000.0)                                    //lambda filter - Filtrace v kroku map. Už je prováděna na ploše spočítané v kroku map
//            .filter("area:(..500)")                                     //jiny zapis filtru bez lambdy
//            .aggregateByTimestamp()                                       //vytvori Mapu podle timestampu
////            .sum();
////            .average();
////            .countUniq();                                                     //vrátí počet unikátních hodnot v daném timestamp
////            .uniq();                                                        //vrátí Set unikátních hodnot v daném timestamp
//            .collect();                                                    //vrati List hodnot v danem timestamp - nemusi byt unikatni
////            .stream();                                                     //vrátí tzv. stream - seznam všech hodnot, ale asi se musí vypisovat v cyklu 
//        
//        int i=0;
//        for (Map.Entry mapElement : result.entrySet()){      //for each loop - Pro každý timestamp projdi List hodnot ploch
//            i=i+1;
//            OSHDBTimestamp key = (OSHDBTimestamp) mapElement.getKey();
//            System.out.print(i+" timestamp: "+key+" ");
//            List<Double> list = (List<Double>) mapElement.getValue();
//            
//            int j=0;
//            for (Double value : list){             //for each loop
//                j=j+1;
//                System.out.print(j+" area: "+value+" ");
//            }            
//        }
//        System.out.println("Diggy diggy hole!");
//    }
    
  
    
    
    
    
//    //ALTERNATIVNÍ ZPŮSOB ZÁPISU   
//    //Snapshot s jedním timestamp
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Number result = OSMEntitySnapshotView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2021-01-01")
//            .filter("type:way and building=*")
//            .count();
//        System.out.println(result);
//        System.out.println("Diggy diggy hole!");
//    }
//
//    
//    //Snapshot s jedním timestamp psaný jinak - ZJEVNE NEFUNGUJE STEJNE JAKO KOD VYSE!
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        MapReducer<OSMEntitySnapshot> snapshotsMapReducer = OSMEntitySnapshotView.on(oshdb);
//        snapshotsMapReducer.areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268));
//        snapshotsMapReducer.timestamps("2021-01-01");
//        snapshotsMapReducer.filter("type:way and building=*");
//        Number result = snapshotsMapReducer.count();
//        System.out.println(result);
//        System.out.println("Diggy diggy hole!");
//    }
    
    
    
    
    
    
    
    
    
//DOTAZ NA UŽIVATELE 
//    Contribution - počet editujících za období - stačí Number, netřeba Set
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Integer result = OSMContributionView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
////            .timestamps("2012-01-01", "2021-01-01", Interval.YEARLY) //Více intervalů vrátí vždy jen hodnotu za celkové období.
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .count(); //449 vrati pocet changesetu
////            .countUniq(); //449 v případě počtu changesetů se count a countUniq neliší
//        System.out.println(result);
//        System.out.println("Diggy diggy hole!");
//    }



    
//    //Contribution - procházení id přispěvatelů a timestamp pomocí cyklu. TOHLE FUNGUJE.
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Set<OSMContribution> result = OSMContributionView.on(oshdb)        //Není povoleno nic než Set - ani HashSet, ani TreeSet       
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .uniq();    //vrátí unikátní changesety = tedy changesety
//        System.out.println("size: "+result.size()); 
//        
//        int i = 0;
//        for (OSMContribution value : result){             //for each loop
//            i=i+1;
//            int userId = value.getContributorUserId();
//            String timestamp = value.getTimestamp().toString();
//            System.out.print(i+": "+timestamp+" "+userId+", ");
//        }
//        System.out.println("Diggy diggy hole!");
//    }

//    //Contribution - procházení id přispěvatelů a timestamp pomocí pole - PROBLEM S PRETYPOVANIM. ASI TEDY NUTNO PROCHAZET CYKLEM
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Set<OSMContribution> result = OSMContributionView.on(oshdb)        //Není povoleno nic než Set - ani HashSet, ani TreeSet       
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .uniq();    //vrátí unikátní changesety = tedy changesety
//         
//        OSMContribution[] pole = (OSMContribution[]) result.toArray(); //Tohle nefunguje - nelze pretypovat.
//        System.out.println("size: "+pole.length);
//        
//        int i = 0;
//        for (OSMContribution value : pole){             //for each loop
//            i = i+1;
//            int userId = value.getContributorUserId();
//            String timestamp = value.getTimestamp().toString();
//            System.out.print(i+": "+timestamp+" "+userId+", ");
//        }
//        System.out.println("Diggy diggy hole!");
//    }    
    
    
    
    
    
//    //Contribution - id přispěvatelů a timestamp a druh změny procházení cyklem. Změny seskupeny podle jednotlivých prvků OSM a seřazeny podle času.
//    //NENÍ použito groupByEntity a NENÍ použito aggregateByTimestamp
//    //seskupi changesety jednotlivych entit a seřadí je podle timestampu od nejstaršího k nejnovějšímu - I BEZ groupByEntity a BEZ aggregateByTimestamp!!!
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        List<OSMContribution> result = OSMContributionView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .collect();    //vrátí unikátní changesety = tedy changesety
//        System.out.println("size: "+result.size()); 
//        
//        int j = 0;
//        for (OSMContribution value : result){
//            j=j+1;
//            System.out.print("j: "+j+" ");
//            long change = value.getChangesetId();
//            long entity = value.getEntityAfter().getId();
//            int userId = value.getContributorUserId();
//            String contrType = value.getContributionTypes().toString();
//            String timestamp = value.getTimestamp().toString();
//            System.out.print("entita: "+entity+" changeset: "+change+" "+timestamp+" "+contrType+" user: "+userId+", ");
//        }
//        System.out.println("Diggy diggy hole!");
//    }
    
//    //Contribution - id přispěvatelů a timestamp a druh změny procházení cyklem. Změny seskupeny podle jednotlivých prvků OSM a seřazeny podle času.
//    //JE použito groupByEntity a NENÍ použito aggregateByTimestamp
//    //seskupi changesety jednotlivych entit a seřadí je podle timestampu od nejstaršího k nejnovějšímu - I BEZ groupByEntity a BEZ aggregateByTimestamp!!!
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        List<List<OSMContribution>> result = OSMContributionView.on(oshdb)
//            .groupByEntity() //Změny budou seskupeny podle jednotlivých prvků a seřazeny podle času - má  se volat hned jako první příkaz
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .collect();    //vrátí unikátní changesety = tedy changesety
//        System.out.println("size: "+result.size()); 
//        
//        int i = 0;
//        for (List<OSMContribution> list : result){
//            i=i+1;
//            System.out.print("i: "+i+" ");
//            int j = 0;
//            for (OSMContribution value : list){
//                j=j+1;
//                System.out.print("j: "+j+" ");
//                long change = value.getChangesetId();
//                long entity = value.getEntityAfter().getId();
//                int userId = value.getContributorUserId();
//                String contrType = value.getContributionTypes().toString();
//                String timestamp = value.getTimestamp().toString();
//                System.out.print("entita: "+entity+" changeset: "+change+" "+timestamp+" "+contrType+" user: "+userId+", ");
//            }
//        }
//        System.out.println("Diggy diggy hole!");
//    }    
    
    

////    //Contribution - id přispěvatelů a timestamp a druh změny procházení cyklem. Změny seskupeny podle jednotlivých prvků OSM a seřazeny podle času.
////    //NENÍ použito groupByEntity a JE použito aggregateByTimestamp
////    //seskupi changesety jednotlivych entit a seřadí je podle timestampu od nejstaršího k nejnovějšímu - I BEZ groupByEntity a BEZ aggregateByTimestamp!!!
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        SortedMap<OSHDBTimestamp,List<OSMContribution>> result = OSMContributionView.on(oshdb)
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .aggregateByTimestamp()
//            .collect();    //vrátí unikátní changesety = tedy changesety
//        
//        int i = 0;
//        for (Map.Entry mapElement : result.entrySet()){                         //for each loop - pro každý timestamp...
//            i=i+1;
//            OSHDBTimestamp timestamp = (OSHDBTimestamp) mapElement.getKey();
//            System.out.print(i+" timestamp: "+timestamp+" ");
//            List<OSMContribution> list = (List<OSMContribution>) mapElement.getValue(); //...získej list contributions
//            
//            int j = 0;
//            for (OSMContribution value : list){             //for each loop - pro každou contribution prvku OSM
//                j=j+1;
//                System.out.print("j: "+j+" ");
//                long change = value.getChangesetId();
//                long entity = value.getEntityAfter().getId();
//                int userId = value.getContributorUserId();
//                String contrType = value.getContributionTypes().toString();
//                String time = value.getTimestamp().toString();
//                System.out.print("entita: "+entity+" changeset: "+change+" "+time+" "+contrType+" user: "+userId+", ");
//            }
//        }
//        System.out.println("Diggy diggy hole!");
//    }    
    
  
    
    
    
//    //Contribution - procházení id přispěvatelů a timestamp pomocí cyklu
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        Set<OSMContribution> result = OSMContributionView.on(oshdb)        //Není povoleno nic než Set - ani HashSet, ani TreeSet       
//            .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))
//            .timestamps("2020-01-01","2021-01-01")
//            .filter("type:way and building=*")
//            .uniq();    //vrátí počet changesetů
//        System.out.println("size: "+result.size()); 
//        
//        int i = 0;
//        for (OSMContribution value : result){             //for each loop
//            i=i+1;
//            int userId = value.getContributorUserId();
//            String timestamp = value.getTimestamp().toString();
//            System.out.print(i+": "+timestamp+" "+userId+", ");
//        }
//        System.out.println("Diggy diggy hole!");
//    }    


    
    
    
////    //EXAMPLES
//
//  //Tutorial - vraci celkovou plochu budov menších než 100 m2
//  public static void main(String[] args) throws Exception {
//    // -- PREPARATION --
//    // Start writing the OSHDB query
//    // declare and open a link to the OSHDB
//    OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//
//    // Select OSHDB view
//    // create a MapReducer on Snapshots
//    MapReducer<OSMEntitySnapshot> mapReducer = OSMEntitySnapshotView.on(oshdb);  
//
//    // Setting spatial extent
//    // create BoundingBox
//    OSHDBBoundingBox boundingBox = OSHDBBoundingBox
//        .bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268);
//    
//    // add the boundingBox to the MapReducer
//    mapReducer = mapReducer.areaOfInterest(boundingBox);
//
//    //Setting temporal extent
//    // add timestamps of interest to the MapReducer
//    mapReducer = mapReducer.timestamps("2014-01-01", "2015-01-01", Interval.MONTHLY);
//
//    // -- FILTER DATA --
//    mapReducer = mapReducer.filter("type:way and building=*");
//
//    // -- Calculating intermediate results --
//    // mapping snapshots to area-values using a separate class
//    MapReducer<Double> mapReducer2 = mapReducer.map(new Mapper());
//
//    // -- Filtering intermediate results --
//    mapReducer2 = mapReducer2.filter(new ResultFilter());
//
//    // -- Requesting aggregated result --
//    // sum
//    Number result = mapReducer2.sum();
//
//    // --Tear Down --
//    oshdb.close();
//
//    // -- RESULT --
//    System.out.println(result);
//  }
//
//  private static class Mapper implements SerializableFunction<OSMEntitySnapshot, Double> {
//
//    @Override
//    public Double apply(OSMEntitySnapshot snapshot) {
//      return Geo.areaOf(snapshot.getGeometry());
//    }
//  }
//
//  private static class ResultFilter implements SerializablePredicate<Double> {
//
//    @Override
//    public boolean test(Double area) {
//      return area < 100.0;
//    }
//  }    
  
    
    
//    //DistinctContributors
//    public static void main(String[] args) throws Exception {
//        OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//        SortedMap<OSHDBTimestamp, Integer> result = OSMContributionView.on(oshdb)        
////          .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268)) //není omezení souřadnicemi. Bere se celý soubor.
//          .timestamps("2020-01-01", "2020-12-01", Interval.MONTHLY)
//          .filter("type:way and highway=*")
//          .map(OSMContribution::getContributorUserId) //???
//          .aggregateByTimestamp()
//          .countUniq();
//        System.out.println("size: "+result.size()); 
//        
//        // output
//        for (Map.Entry<OSHDBTimestamp, Integer> entry : result.entrySet()) {
//          System.out.println(entry.getKey()+" "+entry.getValue() );
//        }    
//        System.out.println("Diggy diggy hole!");
//    }    
    




//  //RoadLegth
//  static final List<String> other = List.of("unclassified", "road", "service", "track", "path",
//      "pedestrian", "footway", "cycleway", "steps", "platform", "bridleway");
//  static final List<String> highway_motorway = List.of(
//      "motorway", "primary", "motorway_link", "primary_link", "trunk", "trunk_link");
//  static final List<String> secondary_tertiary = List.of(
//      "secondary", "secondary_link", "tertiary", "tertiary_link");
//  static final List<String> residential = List.of("residential", "living_street");
//
//  public static void main(String[] args) throws Exception {
//    OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//    SortedMap<OSHDBTimestamp, Number> result = OSMEntitySnapshotView.on(oshdb)  
////          .areaOfInterest(OSHDBBoundingBox.bboxWgs84Coordinates(8.6634,49.3965,8.7245,49.4268))  
//          .timestamps("2010-01-01", "2020-01-01", Interval.YEARLY)
//          .filter("type:way and highway in (" + String.join(",", highway_motorway) + ")")
//          .aggregateByTimestamp()
//          .sum(snapshot -> Geo.lengthOf(snapshot.getGeometry()) / 1000);
//    
//    for (Map.Entry<OSHDBTimestamp, Number> entry : result.entrySet()) {
//        System.out.println(""+entry.getKey()+" "+entry.getValue());
//    }
//    System.out.println("Diggy diggy hole!");
//  }
  
    
    


    
    
    
    
  
  
    
//  //AdvancedExample - kód odkazuje na externí soubor a definuje si nové třídy a tvoří graf
//  public static void main(String[] args) throws Exception {
//    OSHDBDatabase oshdb = new OSHDBH2("D:/NetBeansProjects/heidelberg.oshdb.mv.db");
//    SortedMap<OSHDBTimestamp, Map<ContributionType, Integer>> reduce = OSMContributionView.on(oshdb) //vůbec zde není uvedeno omezení souřadnicemi! Bere se celé území.
//          .timestamps("2019-01-01", "2020-01-01", OSHDBTimestamps.Interval.MONTHLY)
//          .filter("geometry:polygon and building=*")
//          .map(new Mapper())
//          .aggregateByTimestamp()
//          .reduce(new IdentitySupplier(), new Combiner());
//    
//    //Display Result
//    TutorialChart chart = new TutorialChart("BigDB Analyses", "Contribution-Types per timestamp!", reduce);
//    chart.pack();
//    RefineryUtilities.centerFrameOnScreen(chart);
//    chart.setVisible(true);
//    System.out.println("Diggy diggy hole!");
//  }
//
//  private static class Mapper implements
//      SerializableFunction<OSMContribution, Map<ContributionType, Integer>> {
//
//    @Override
//    public Map<ContributionType, Integer> apply(OSMContribution contribution) {
//      //get an empty result-map
//      Map<ContributionType, Integer> result = new IdentitySupplier().get();
////      System.out.println("changeset: "+contribution.getChangesetId());
////      System.out.println("Entity id: "+contribution.getEntityBefore().getId());
////      System.out.println("contributionTypes: "+contribution.getContributionTypes());
//      //count contribution-types
//      contribution.getContributionTypes().forEach((var type) ->                 //Kdyz potrebujete do Lambda expression pridat dalsi radek, pouzijte lomene zavorky.
//            {
//              System.out.println("changeset: "+contribution.getChangesetId());
//              System.out.println("Entity id: "+contribution.getEntityAfter().getId());
//              System.out.println("contributionTypes: "+contribution.getContributionTypes());
//              result.put(type, result.get(type) + 1);
////              System.out.println("type: "+type+" "+result.get(type)+" ");
//            });
//      return result;
//    }
//  }
//
//  private static class IdentitySupplier implements
//      SerializableSupplier<Map<ContributionType, Integer>> {
//
//    @Override
//    public Map<ContributionType, Integer> get() {
//      //create an empty result-map
//      Map<ContributionType, Integer> result = new EnumMap<>(ContributionType.class);
//      //fill with 0 values
//      Arrays.asList(ContributionType.values())
//          .forEach(type -> result.put(type, 0));
//      return result;
//    }
//  }
//
//  private static class Combiner implements
//      SerializableBinaryOperator<Map<ContributionType, Integer>> {
//
//    @Override
//    public Map<ContributionType, Integer> apply(
//        Map<ContributionType, Integer> mapResultA,
//        Map<ContributionType, Integer> mapResultB) {
//      //get an empty result-map
//      Map<ContributionType, Integer> result = new IdentitySupplier().get();
//      //put all counts of map-result A
//      result.putAll(mapResultA);
//      //sum up with all result from map-result B
//      mapResultB.forEach((ContributionType contribType, Integer integ) ->
//          result.merge(contribType, integ, Integer::sum));
//      return result;
//    }
//  } 
    
     
}
