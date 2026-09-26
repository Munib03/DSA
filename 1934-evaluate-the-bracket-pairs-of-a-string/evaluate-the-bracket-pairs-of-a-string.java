class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        var map = addToMap(knowledge);

        var sb = new StringBuilder();
        var flag = false;
        var key = new StringBuilder();

        for (var ch : s.toCharArray()) {
            if (ch == '(') 
                flag = true;
            
            else if (ch == ')') {
                if (map.containsKey(key.toString()))
                    sb.append(map.get(new String(key)));
                else
                    sb.append('?');

                flag = false;
                key = new StringBuilder();
            } 
            else if (flag) 
                key.append(ch);
            else
                sb.append(ch);
        }

        return sb.toString();
    }

    private Map<String, String> addToMap(List<List<String>> list) {
        var map = new HashMap<String, String>();

        for (var sth : list)
            map.put(sth.getFirst(), sth.getLast());

        return map;
    }
}