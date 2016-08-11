package home.eighth.src.test.java;

import home.eighth.src.main.java.MyList;
import org.junit.*;

import java.util.Iterator;

public class MyListTest {
    private MyList<String> myList;
    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @Before
    public void initial() {
        myList = new MyList<>();
    }

    @Test(expected = NullPointerException.class)
    public void test_NPE(){
        myList = null;
        myList.get(1);
    }

    @Test
    public void test_add(){
        myList.add("0");
        myList.add("1");
        myList.add("2");
    }

    @Test(timeout = 100)
    @Ignore
    public void test_add_2(){
        for(int i = 0; i < 100000; i++)
            myList.add("0");
    }

    @Test
    public void test_get_assert(){
        myList.add("0");
        myList.add("1");
        Assert.assertEquals("Не содержится элемент "+myList.get(0),myList.get(0), "0");
        Assert.assertEquals("Не содержится элемент "+myList.get(1),myList.get(1), "1");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Test_IOoBE(){
        myList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Test_IOoBE_2(){
        myList.get(8);
    }

    @Test
    public void testAddAfterRemove() {
        myList.add("a");
        myList.add("b");
        myList.remove(1);
        myList.remove(0);
        myList.add("c");
        Assert.assertEquals("0 = "+myList.get(0),"c", myList.get(0));
    }

    @Test
    public void testAddAfterRemove2(){
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.remove(2);
        myList.add("4");

        Assert.assertEquals(myList.get(0), "1");
        Assert.assertEquals(myList.get(1), "2");
        Assert.assertEquals("0 = "+myList.get(2),myList.get(2), "4");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Test_Remove_IOoBE(){
        myList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Test_Remove_IOoBE_2(){
        myList.add("0");
        myList.remove(2);
    }

    @Test
    public void Test_getIter(){
        Iterator<String> it = myList.iterator();
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testClassicIteration() {
        myList.add("");
        myList.add("");
        final Iterator<String> it = myList.iterator();
        int items = 0;
        while (it.hasNext()) {
            it.next();
            items++;
        }
        Assert.assertEquals("Содержит 2 элемента",2, items);
    }

    @After
    public void clear(){
        myList=null;
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }
}
