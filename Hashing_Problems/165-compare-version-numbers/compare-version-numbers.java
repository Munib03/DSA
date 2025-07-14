class Solution {
    public int compareVersion(String version1, String version2) {
        var arr1 = version1.split("\\.");
        var arr2 = version2.split("\\.");

        var i = 0;
        var j = 0;

        while (i < arr1.length && j < arr2.length) {
            var me = Integer.parseInt(arr1[i]);
            var ou = Integer.parseInt(arr2[j]);

            if (me > ou)
                return 1;
            else if (me < ou)
                return -1;

            i++;
            j++;
        }

        while (i < arr1.length) {
            if (Integer.parseInt(arr1[i]) > 0)
                return 1;

            i++;
        }

        while (j < arr2.length) {
            if (Integer.parseInt(arr2[j]) > 0)
                return -1;

            j++;
        }

        return 0;
    }
}