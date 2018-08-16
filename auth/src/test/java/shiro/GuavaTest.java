package shiro;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.*;

import java.util.*;

/**
 * @author lee
 * @Date:2018/4/17
 */

public class GuavaTest {

    public static void main(String[] args) {

        List<String> testList = new ArrayList<>();
        testList.add("aa");
        testList.add("bb");
        testList.add(null);
        testList.add("cc");

        //Joiner
        String joinerStr = Joiner.on('|').useForNull("null").join(testList);
        System.out.println(joinerStr);
        System.out.println(Joiner.on('|').skipNulls().join(testList));

        Map<String, Object> aa = new HashMap<>();
        aa.put("aa", "aValue");
        aa.put("bb", "bValue");
        aa.put("cc", "cValue");

        Joiner.MapJoiner ab = Joiner.on("#").withKeyValueSeparator('=');
        System.out.println(ab.join(aa));

        Splitter splitter = Splitter.on("|").trimResults();

        Iterable<String> sa = splitter.split(joinerStr);

        sa.forEach(a -> System.out.println(a));

        //符号填充 第二个参数的长度如果小于原数据的长度 则无效
        System.out.println(Strings.padEnd("foolishaaaaaa", 10, 'x'));
        String stra = null;
        System.out.println(Strings.isNullOrEmpty(stra));
        System.out.println(Strings.nullToEmpty(stra));
        System.out.println(Strings.emptyToNull(stra));

        System.out.println(CharMatcher.whitespace().trimAndCollapseFrom("  you ra is a al", ' '));

        String a = "sss";
        System.out.println(CharMatcher.javaDigit().retainFrom(a));


        List<String> ga = Lists.newArrayList("\"aaa", "\"ccc", "\"xxx", "\"ddd");

        List<List<String>> al = Lists.partition(ga, 2);

        al.forEach(ala -> System.out.println(ala.size() + ">>" + ala.toString()));

        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");


        Sets.SetView setView = Sets.symmetricDifference(s1, s2);
        System.out.println(Joiner.on("|").skipNulls().join(setView));

        //交集
        System.out.println(Joiner.on("|").skipNulls().join(Sets.intersection(s1, s2)));

        System.out.println(Joiner.on("|").skipNulls().join(Sets.union(s1, s2)));


        List<Book> books = Lists.newArrayList(new Book("xyj"), new Book("hlm"));
        Map<String, Book> bookMap = Maps.uniqueIndex(books.iterator(), Book::getName);
        System.out.println(Joiner.on("|").withKeyValueSeparator("=").join(bookMap));


        ArrayListMultimap multimap = ArrayListMultimap.create();
        multimap.put("a", 1);
        multimap.put("a", 2);
        multimap.put("a", 3);
        multimap.put("a", 3);

        multimap.put("b", 1);
        multimap.put("b", 2);
        multimap.put("b", 3);
        multimap.put("b", 3);

        System.out.println(multimap.get("a"));
        System.out.println(multimap.size());

        Map map = multimap.asMap();

        System.out.println(map.size());
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));

        HashMultimap<String, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put("b", 1);
        hashMultimap.put("b", 2);
        hashMultimap.put("b", 3);
        hashMultimap.put("b", 3);

        System.out.println(hashMultimap.get("b"));
        System.out.println(hashMultimap.size());

        BiMap biMap = HashBiMap.create();

        biMap.put("1", "tom");
        biMap.forcePut("2", "tom");

        System.out.println(biMap.get("1"));
        System.out.println(biMap.get("2"));

        BiMap inverseMap = biMap.inverse();

        System.out.println(inverseMap.get("tom"));


        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "Rook");
        table.put(1, 2, "Knight");
        table.put(1, 3, "Bishop");

        System.out.println(table.get(1, 2));
        System.out.println(table.containsValue("Bishop"));

        Map<Integer, String> columnMap = table.column(1);
        System.out.println(Joiner.on("|").withKeyValueSeparator('=').join(columnMap));

        Map<Integer, String> rowMap = table.row(1);
        System.out.println(Joiner.on("|").withKeyValueSeparator('=').join(rowMap));

        ImmutableListMultimap<Integer, String> build = new ImmutableListMultimap.Builder<Integer, String>()
                .put(1, "Foo").putAll(2, "Foo", "Bar", "Baz").build();
        System.out.println(build.get(1));
        System.out.println(build.get(2));

        String usableItems = "1,2,3,4,5";
        String usableParts = "1,7,8,9";
        List<String> ui = Splitter.on(',').splitToList(usableItems);
        List<String> up = Splitter.on(',').splitToList(usableParts);
        System.out.println(Collections.disjoint(ui,up));


        System.out.println(Splitter.on(',').splitToList(""));
    }
}

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
