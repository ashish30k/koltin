public class JavaDelegation {

    public void delegate() {
        View view = new View();
        Screen screen = new Screen(view);// establishes delegation b/w two objects
        screen.show();
    }


    class View {
        void show() {
            System.out.println("View Showing");
        }
    }

    class Screen {
        private View view; // delegate link

        public Screen(View view) {
            this.view = view;
        }

        void show() {
            view.show(); // delegates show functionality to view object i.e. 'delegate'
        }
    }
}
