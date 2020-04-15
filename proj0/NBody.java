public class NBody {
    public static double readRadius(String filename) {
        In a = new In(filename);
        a.readInt();
        double r = a.readDouble();
        return r;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int total = in.readInt();
        in.readDouble();
        int i = 0;
        Planet[] Planets = new Planet[total];
        while (i < total) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planets[i++] = new Planet(xP, yP, xV, yV, m, img);
        }
        return Planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double uniRadius = NBody.readRadius(filename);
        Planet[] Planets = NBody.readPlanets(filename);

        StdDraw.setScale(-uniRadius, uniRadius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Planet planet : Planets) {
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t <= T) {
            double[] xForces = new double[Planets.length];
            double[] yForces = new double[Planets.length];
            for (int i = 0; i < Planets.length; i++) {
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }

            for (int i = 0; i < Planets.length; i++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Planet p : Planets) {
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t = t + dt;
        }

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", Planets[i].xxPos, Planets[i].yyPos,
                    Planets[i].xxVel, Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
    }
}