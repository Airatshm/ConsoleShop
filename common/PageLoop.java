package shopdata.common;

import java.util.Scanner;

public class PageLoop {
    final AppView view;

    int getChildrenSize() {
        return view.children.size();
    }

    int getOptionalSize() {
        int optionalSize = 0;
        if (view.hasNextPage) optionalSize++;
        optionalSize += view.availableComparators.size();
        return optionalSize;
    }

    public PageLoop(AppView view) {

        this.view = view;
    }

    public void run() {
        while (true) {
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalSize() + 1;
            try (Scanner in = new Scanner(System.in)) {
                int value = in.nextInt();
                if (value < 0 || value > fullSize) {
                    System.out.println("Неверное значение страницы");
                } else if (value == fullSize) {
                    break;
                } else if (value < getChildrenSize()) {
                    AppView selectedView = view.children.get(value - 1);
                    new PageLoop(selectedView).run();
                } else {

                    if (value == getChildrenSize() && view.hasNextPage) {
                        view.nowPage++;
                        new PageLoop(view).run();
                    } else {
                        view.nowPage = 0;
                        int comparatorIndex = value - getChildrenSize() - 1 - (view.hasNextPage ? 1 : 0);
                        view.selectedComparator = view.availableComparators.get(comparatorIndex);
                        new PageLoop(view).run();
                    }


                }
            }
        }
    }

    void displayChildren() {
        int currentIndex = 1;
        System.out.println(view.title);
        System.out.println("Выберите вариант (от 1 до " + (view.children.size() + 1) + ")");
        for (int i = 0; i < view.children.size(); i++) {
            AppView _view = view.children.get(i);
            System.out.println(currentIndex + "-" + _view.title);
            currentIndex++;
        }
        if (view.hasNextPage) {
            System.out.println(currentIndex + "-" + "Следующая страница");
            currentIndex++;
        }
        for (int i = 0; i < view.availableComparators.size(); i++) {
            System.out.println(currentIndex + "-" + view.availableComparators.get(i).name);
            currentIndex++;
        }
        System.out.println((getChildrenSize() + getOptionalSize() + 1) + " - Назад");
    }
}

