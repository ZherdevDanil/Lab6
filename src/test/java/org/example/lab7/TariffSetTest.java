package org.example.lab7;

import org.example.CheapTariff;
import org.example.MediumTariff;
import org.example.PremiumTariff;
import org.example.Tariff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TariffSetTest {
    private TariffSet tariffSet;
    private List<Tariff> tariffList;
    private Tariff tariff1;
    private Tariff tariff2;
    private Tariff tariff3;


    @BeforeEach
    public void setUp(){
        tariffSet = new TariffSet();
        tariff1 = new CheapTariff("SuperNet Start", 175, 140000);
        tariff2 = new MediumTariff("Red Unlim Max", 350, 115000);
        tariff3= new PremiumTariff("Ultra Vip", 900, 20000);

        tariffList = List.of(tariff1,tariff2);
    }

    @Test
    public void testAdd(){
        assertTrue(tariffSet.add(tariff1));
        assertEquals(1,tariffSet.size());
        assertFalse(tariffSet.add(tariff1));
        assertEquals(1,tariffSet.size());
        assertTrue(tariffSet.contains(tariff1));
    }

    @Test
    public void testSize(){
        assertEquals(0,tariffSet.size());
        tariffSet.add(tariff1);
        assertEquals(1,tariffSet.size());
        tariffSet.add(tariff2);
        assertEquals(2,tariffSet.size());
    }

    @Test
    public void testRemove(){
        tariffSet.add(tariff1);
        assertTrue(tariffSet.contains(tariff1));
        assertTrue(tariffSet.remove(tariff1));
        assertEquals(0,tariffSet.size());
    }

    @Test
    public void testContains(){
        tariffSet.add(tariff1);
        assertTrue(tariffSet.contains(tariff1));
        assertFalse(tariffSet.contains(tariff2));
    }
    @Test
    public void testContainsAll(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        assertTrue(tariffSet.containsAll(tariffList));
    }
    @Test
    public void testAddAll(){
        tariffSet.addAll(tariffList);
        assertEquals(2,tariffSet.size());
        assertTrue(tariffSet.contains(tariff1));
        assertTrue(tariffSet.contains(tariff2));
    }
    @Test
    public void testRetainAll(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        tariffSet.add(tariff3);
        assertEquals(3,tariffSet.size());
        tariffSet.retainAll(tariffList);
        assertFalse(tariffSet.contains(tariff3));
    }
    @Test
    public void testRemoveAll(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        tariffSet.add(tariff3);
        assertEquals(3,tariffSet.size());
        tariffSet.removeAll(tariffList);
        assertEquals(1,tariffSet.size());
        assertFalse(tariffSet.contains(tariff1));
        assertFalse(tariffSet.contains(tariff1));
    }
    @Test
    public void testClear(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        assertEquals(2,tariffSet.size());
        tariffSet.clear();
        assertEquals(0,tariffSet.size());
    }
    @Test
    public void testIsEmpty(){
        assertTrue(tariffSet.isEmpty());
        tariffSet.add(tariff1);
        assertFalse(tariffSet.isEmpty());
    }
    @Test
    public void testToArray(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        Object[] array = tariffSet.toArray();
        assertTrue(array.length==2);
    }

    @Test
    public void testToArrayWithParam(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        Tariff[] tariffArray = new Tariff[2];
        tariffArray = tariffSet.toArray(tariffArray);
        assertEquals(tariff1,tariffArray[0]);
        assertEquals(tariff2,tariffArray[1]);
    }
    @Test
    public void testIterator(){
        tariffSet.add(tariff1);
        tariffSet.add(tariff2);
        tariffSet.add(tariff3);
        Iterator<Tariff> iterator = tariffSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(tariff1,iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(tariff2,iterator.next());
        iterator.remove();
        assertFalse(tariffSet.contains(tariff3));
    }

}