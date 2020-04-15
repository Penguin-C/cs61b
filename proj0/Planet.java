public class Planet {
    public double xxPos; // Its current x position
    public double yyPos; // Its current y position
    public double xxVel; // Its current velocity in the x direction
    public double yyVel; // Its current velocity in the y direction
    public double mass; // Its mass
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }

    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        double F = (G * this.mass * p.mass) / (r * r);
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double F = this.calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double Fx = (F * dx) / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double F = this.calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double Fy = (F * dy) / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double netFx = 0;
        for (int i = 0; i < p.length; i++) {
            if (!this.equals(p[i])) {
                netFx = netFx + this.calcForceExertedByX(p[i]);
            }
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double netFy = 0;
        for (int i = 0; i < p.length; i++) {
            if (!this.equals(p[i])) {
                netFy = netFy + this.calcForceExertedByY(p[i]);
            }
        }
        return netFy;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}