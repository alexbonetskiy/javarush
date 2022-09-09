package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone;
        clone = solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);

    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public Solution clone() {
        try {
            Solution o = (Solution) super.clone();

            //clone users
            Map<String, User> newUsers = new LinkedHashMap<>();
            for (String key : o.users.keySet()) {
                User user = o.users.get(key);
                newUsers.put(key, user.clone());
            }
            o.users = newUsers;

            return o;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() {
            try {
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return (User) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
