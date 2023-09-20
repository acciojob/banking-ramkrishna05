package com.driver;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000); // minimum balance is 5000 by default
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        if (!isValidLicenseId()) {
            rearrangeLicenseId();
        }
    }

    private boolean isValidLicenseId() {
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void rearrangeLicenseId() throws Exception {
        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    if (i == 0 && c != chars[i + 1]) {
                        chars[i] = c;
                        break;
                    } else if (i > 0 && c != chars[i - 1] && c != chars[i + 1]) {
                        chars[i] = c;
                        break;
                    }
                }
            }
        }
        tradeLicenseId = new String(chars);

        if (!isValidLicenseId()) {
            throw new Exception("Valid License cannot be generated");
        }
    }
}
