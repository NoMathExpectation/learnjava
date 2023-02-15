package nme.cs102.assignment2;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long r = sc.nextLong();
        sc.close();
        if (r == 0) {
            System.out.println(1);
        } else {
            int i = 0;
            Result result = new Result(false, 0, r, r * r, Circle::nextX);
            while (result.y > 0) {
                result = result.next();
                if (result.result) {
                    i++;
                }
            }
            System.out.println(++i * 4);
        }
    }

    public static Result nextX(long x0, long y0, long r2) {
        long x = (long) Math.ceil(Math.sqrt(r2 - y0 * y0));
        if (x == x0) {
            return new Result(false, x, y0 - 1, r2, Circle::nextX);
        }
        if (x * x + y0 * y0 == r2 && x * x < r2) {
            return new Result(true, x, y0 - 1, r2, Circle::nextX);
        }
        return new Result(false, x, y0, r2, Circle::nextY);
    }

    public static Result nextY(long x0, long y0, long r2) {
        long y = (long) Math.floor(Math.sqrt(r2 - x0 * x0));
        if (y == y0) {
            return new Result(false, x0 + 1, y, r2, Circle::nextY);
        }
        if (x0 * x0 + y * y == r2 && y > 0) {
            return new Result(true, x0 + 1, y, r2, Circle::nextY);
        }
        return new Result(false, x0, y, r2, Circle::nextX);
    }

    static class Result {
        public final boolean result;
        public final long x;
        public final long y;
        public final long r2;
        public final Next next;

        Result(boolean result, long x, long y, long r2, Next next) {
            this.result = result;
            this.x = x;
            this.y = y;
            this.r2 = r2;
            this.next = next;
        }

        public Result next() {
            return next.next(x, y, r2);
        }
    }

    interface Next {
        Result next(long a, long b, long c);
    }
}
