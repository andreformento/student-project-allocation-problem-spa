package Controller;

import Model.*;

/**
 * Created by rares on 01.03.2016.
 */

/**
 * Abstract class from which will derive 2 types of algorithms: a random one and a stable one.
 */
public abstract class Solver {
    Problem problem;

    public Solver(Problem problem) {
        this.problem = problem;
    }

    public abstract void execute();
}
