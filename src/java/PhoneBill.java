import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBill {

    public int solution(String S) {
        String calls[] = S.split("\r?\n");
        String phoneWithPromotion = "";

        Integer maxDuration = 0;
        Map<String, Integer> phoneDurations = new HashMap<>();
        for (String call: calls) {
            Pattern pattern = Pattern.compile("([\\d]+):([\\d]+):([\\d]+),([\\d]+\\-[\\d]+\\-[\\d]+)");
            Matcher matcher = pattern.matcher(call);
            while (matcher.find()) {
                int hrs = Integer.parseInt(matcher.group(1));
                int mins = Integer.parseInt(matcher.group(2));
                int secs = Integer.parseInt(matcher.group(3));
                String phoneNo = matcher.group(4);
//                System.out.println (hrs + "# " + mins + "# " +  secs + "# " +  phoneNo);

                int durationInSecs = hrs * 60 * 60 + mins * 60 + secs;
                int perPhoneDuration = durationInSecs;
                if (phoneDurations.containsKey(phoneNo)) {
                    perPhoneDuration = phoneDurations.get(phoneNo) + durationInSecs;
                }
                phoneDurations.put(phoneNo, perPhoneDuration);
                if (perPhoneDuration > maxDuration) {
                    phoneWithPromotion = phoneNo;
                } else if (perPhoneDuration == maxDuration) {
                    // no changes to bill since no changes to duration
                }
            }
        }
        phoneDurations.remove(phoneWithPromotion);

        int totalBill = 0;
        for (String phone: phoneDurations.keySet()) {
            Integer secs = phoneDurations.get(phone);
            if (secs > 60) {
                int mins = secs / 60;
                int secsWithinMin = secs % 60;
                int bill = calculateForDuration(mins, secsWithinMin);
                totalBill += bill;
            }
        }
        return totalBill;
    }

    private int calculateForDuration(int mins, int secs) {
        int bill = 0;
        if (mins > 5) {
            bill = mins * 150;
        } else if (mins == 5) {
            bill =  (secs > 0)? 6 * 150 : 5 * 150;
        } else {
            bill = (mins * 60 + secs) * 3;
        }
        return bill;
    }

    public static void main(String[] args) {
        String S =
                "00:01:07,400-234-090\n" +
                        "00:05:01,701-080-080\n" +
                        "00:05:00,400-234-090";

        PhoneBill phoneBill = new PhoneBill();
        System.out.println (phoneBill.solution(S));

    }
}
