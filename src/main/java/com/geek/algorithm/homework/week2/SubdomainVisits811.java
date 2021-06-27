package com.geek.algorithm.homework.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nick
 * @date 2021/6/27 11:03 AM
 * @package com.geek.algorithm.homework.week2
 * @description
 *
 *   811. 子域名访问计数
 *   https://leetcode-cn.com/problems/subdomain-visit-count/
 *
 */
public class SubdomainVisits811 {

    /**
     * 811. 子域名访问计数
     *
     * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
     *
     * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param cpdomains
     * @return
     *
     */
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        // 判断是否继续放入countMap
        for (String cpdomain :cpdomains) {
            // 判段google.mail.com，mail.com，com是否都计算了
            int lock = 0;
            String[] arr = cpdomain.split(" ");
            // 子域名的频次
            int frequent = Integer.parseInt(arr[0]);
            String domain = arr[1];
            do {
                int value = countMap.getOrDefault(domain, 0);
                value += frequent;
                countMap.put(domain, value);
                System.out.println("compute domain:" + domain + ", value:" + value);
                // google.mail.com，mail.com，com逐步递减
                domain = domain.substring(domain.indexOf(".") + 1);
                if (!domain.contains(".")) {
                    // 第一次为com/org
                    lock++;
                }
            } while(lock < 2); //
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result.add(value + " " + key);
            System.out.println("result domain:" + key + ", value:" + value);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[]
                {"900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"};
        subdomainVisits(arr);
    }

}
