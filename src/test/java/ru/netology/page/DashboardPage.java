package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonFirst = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement buttonSecond = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");

    private ElementsCollection cards = $$(".list__item");
    private final String balanceBefore = "баланс: ";
    private final String balanceAfter = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public int getCardBalance(int i) {
        val text = cards.get(i).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceBefore);
        val finish = text.indexOf(balanceAfter);
        val value = text.substring(start + balanceBefore.length(), finish);
        return Integer.parseInt(value);
    }

    public CardPage personFirstCard() {
        buttonFirst.click();
        return new CardPage();
    }

    public CardPage personSecondCard() {
        buttonSecond.click();
        return new CardPage();
    }
}
