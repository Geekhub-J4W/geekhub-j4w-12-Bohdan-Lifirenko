package edu.geekhub.homework.user.operatins;

public class Emails {
    private Emails() {
    }

    public static boolean contains(String[] emails, String key) {
        for (String email : emails) {
            if (key.equals(email)) {
                return true;
            }
        }

        return false;
    }
}
