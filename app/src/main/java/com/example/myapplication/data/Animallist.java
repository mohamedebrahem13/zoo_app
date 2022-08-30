package com.example.myapplication.data;

import android.app.Application;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;

public class Animallist extends Application {
   private static ArrayList<Animal>   animallist = new ArrayList<>();
   private static String[] alpha=new String[26];

    public Animallist() {

        setanimallist();
        setalphabetlist();
    }

    public static ArrayList<Animal> getAnimallist() {
        return animallist;
    }


    public static String[] getAlpha() {
        return alpha;
    }

    private void setalphabetlist(){
        for (int i=0,j=65;i<26;i++,j++){
            alpha[i]=Character.toString((char) j);
        }


    }

    private void setanimallist(){

        animallist = new ArrayList<>();
        animallist.add(new Animal(R.raw.lion, "lion", R.drawable.l,"They have an archetypal roar which is used to communicate with other group members and warn different intruders of territorial boundaries.\n" +
                "\n" +
                "They have long, retractable claws which help the lion to grab and hold prey. They also have a rough tongue that helps them peel the skin of prey animals away from flesh and flesh away from bone. Across their belly, they have loose skin which allows the species to be kicked by prey with little chance of an injury.A lioness is ready to have young when she is 2–3 years old. Young lions are called cubs. Cubs are born after \u200B3 1⁄2 months. The cubs are born blind; their eyes do not open until they are about a week old, and cannot see well until they are about two weeks old. Lions do not have a den (home) where they would live for a long time. The lioness conceals the cubs in thick bush, gullies, or rocky outcrops. If the hiding place has been seen by other predators, then the lioness will move the cubs to a new hiding place. The cubs will be introduced to the pride at about 6 weeks old. The cubs are very vulnerable when the lioness goes out to hunt and needs to leave the cubs behind. Also, when a new male takes over a pride from another male, he usually kills all of the cubs. The cubs' mothers will then mate with the new pride male, which means that the first batch of new cubs will be his offspring. A litter of 2-6 cubs are born. Usually, only 1-2 cubs survive until introduced to the pride, at which point they are protected by the whole pride."));
        animallist.add(new Animal(R.raw.monkey2,"monkey", R.drawable.m,"Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, also known as the simians. Traditionally, all animals in the group now known as simians are counted as monkeys except the apes, which constitutes an incomplete paraphyletic grouping; however, in the broader sense based on cladistics, apes (Hominoidea) are also included, making the terms monkeys and simians synonyms in regards to their scope Some characteristics are shared among the groups; most New World monkeys have long tails, with those in the Atelidae family being prehensile, while Old World monkeys have non-prehensile tails or no visible tail at all. Old World monkeys have trichromatic color vision like that of humans, while New World monkeys may be trichromatic, dichromatic, or—as in the owl monkeys and greater galagos—monochromatic. Although both the New and Old World monkeys, like the apes, have forward-facing eyes, the faces of Old World and New World monkeys look very different, though again, each group shares some features such as the types of noses, cheeks and rumps"));
        animallist.add(new Animal(R.raw.elephant, "elephant", R.drawable.e,"ephants are the largest existing land animals. Three living species are currently recognised: the African bush elephant, the African forest elephant, and the Asian elephant. They are the only surviving members of the family Elephantidae and the order Proboscidea. The order was formerly much more diverse during the Pleistocene, but most species became extinct during the Late Pleistocene epoch. Distinctive features of elephants include a long proboscis called a trunk, tusks, large ear flaps, pillar-like legs, and tough but sensitive skin. The trunk is used for breathing, bringing food and water to the mouth, and grasping objects. Tusks, which are derived from the incisor teeth, serve both as weapons and as tools for moving objects and digging. The large ear flaps assist in maintaining a constant body temperature as well as in communication. African elephants have larger ears and concave backs, whereas Asian elephants have smaller ears, and convex or level backs.\n" +
                "\n" +
                "Elephants are scattered throughout sub-Saharan Africa, South Asia, and Southeast Asia and are found in different habitats, including savannahs, forests, deserts, and marshes. They are herbivorous, and they stay near water when it is accessible. They are considered to be keystone species, due to their impact on their environments. Elephants have a fission–fusion society, in which multiple family groups come together to socialise. Females (cows) tend to live in family groups, which can consist of one female with her calves or several related females with offspring. The groups, which do not include bulls, are usually led by the oldest cow, known as the matriarch."));
        animallist.add(new Animal(R.raw.elephant, "elephant", R.drawable.e,"ephants are the largest existing land animals. Three living species are currently recognised: the African bush elephant, the African forest elephant, and the Asian elephant. They are the only surviving members of the family Elephantidae and the order Proboscidea. The order was formerly much more diverse during the Pleistocene, but most species became extinct during the Late Pleistocene epoch. Distinctive features of elephants include a long proboscis called a trunk, tusks, large ear flaps, pillar-like legs, and tough but sensitive skin. The trunk is used for breathing, bringing food and water to the mouth, and grasping objects. Tusks, which are derived from the incisor teeth, serve both as weapons and as tools for moving objects and digging. The large ear flaps assist in maintaining a constant body temperature as well as in communication. African elephants have larger ears and concave backs, whereas Asian elephants have smaller ears, and convex or level backs.\n" +
                "\n" +
                "Elephants are scattered throughout sub-Saharan Africa, South Asia, and Southeast Asia and are found in different habitats, including savannahs, forests, deserts, and marshes. They are herbivorous, and they stay near water when it is accessible. They are considered to be keystone species, due to their impact on their environments. Elephants have a fission–fusion society, in which multiple family groups come together to socialise. Females (cows) tend to live in family groups, which can consist of one female with her calves or several related females with offspring. The groups, which do not include bulls, are usually led by the oldest cow, known as the matriarch."));

        animallist.add(new Animal(R.raw.lion, "lion", R.drawable.l,"They have an archetypal roar which is used to communicate with other group members and warn different intruders of territorial boundaries.\n" +
                "\n" +
                "They have long, retractable claws which help the lion to grab and hold prey. They also have a rough tongue that helps them peel the skin of prey animals away from flesh and flesh away from bone. Across their belly, they have loose skin which allows the species to be kicked by prey with little chance of an injury.A lioness is ready to have young when she is 2–3 years old. Young lions are called cubs. Cubs are born after \u200B3 1⁄2 months. The cubs are born blind; their eyes do not open until they are about a week old, and cannot see well until they are about two weeks old. Lions do not have a den (home) where they would live for a long time. The lioness conceals the cubs in thick bush, gullies, or rocky outcrops. If the hiding place has been seen by other predators, then the lioness will move the cubs to a new hiding place. The cubs will be introduced to the pride at about 6 weeks old. The cubs are very vulnerable when the lioness goes out to hunt and needs to leave the cubs behind. Also, when a new male takes over a pride from another male, he usually kills all of the cubs. The cubs' mothers will then mate with the new pride male, which means that the first batch of new cubs will be his offspring. A litter of 2-6 cubs are born. Usually, only 1-2 cubs survive until introduced to the pride, at which point they are protected by the whole pride."));
        animallist.add(new Animal(R.raw.lion, "lion", R.drawable.l,"They have an archetypal roar which is used to communicate with other group members and warn different intruders of territorial boundaries.\n" +
                "\n" +
                "They have long, retractable claws which help the lion to grab and hold prey. They also have a rough tongue that helps them peel the skin of prey animals away from flesh and flesh away from bone. Across their belly, they have loose skin which allows the species to be kicked by prey with little chance of an injury.A lioness is ready to have young when she is 2–3 years old. Young lions are called cubs. Cubs are born after \u200B3 1⁄2 months. The cubs are born blind; their eyes do not open until they are about a week old, and cannot see well until they are about two weeks old. Lions do not have a den (home) where they would live for a long time. The lioness conceals the cubs in thick bush, gullies, or rocky outcrops. If the hiding place has been seen by other predators, then the lioness will move the cubs to a new hiding place. The cubs will be introduced to the pride at about 6 weeks old. The cubs are very vulnerable when the lioness goes out to hunt and needs to leave the cubs behind. Also, when a new male takes over a pride from another male, he usually kills all of the cubs. The cubs' mothers will then mate with the new pride male, which means that the first batch of new cubs will be his offspring. A litter of 2-6 cubs are born. Usually, only 1-2 cubs survive until introduced to the pride, at which point they are protected by the whole pride."));
        animallist.add(new Animal(R.raw.lion, "lion", R.drawable.l,"They have an archetypal roar which is used to communicate with other group members and warn different intruders of territorial boundaries.\n" +
                "\n" +
                "They have long, retractable claws which help the lion to grab and hold prey. They also have a rough tongue that helps them peel the skin of prey animals away from flesh and flesh away from bone. Across their belly, they have loose skin which allows the species to be kicked by prey with little chance of an injury.A lioness is ready to have young when she is 2–3 years old. Young lions are called cubs. Cubs are born after \u200B3 1⁄2 months. The cubs are born blind; their eyes do not open until they are about a week old, and cannot see well until they are about two weeks old. Lions do not have a den (home) where they would live for a long time. The lioness conceals the cubs in thick bush, gullies, or rocky outcrops. If the hiding place has been seen by other predators, then the lioness will move the cubs to a new hiding place. The cubs will be introduced to the pride at about 6 weeks old. The cubs are very vulnerable when the lioness goes out to hunt and needs to leave the cubs behind. Also, when a new male takes over a pride from another male, he usually kills all of the cubs. The cubs' mothers will then mate with the new pride male, which means that the first batch of new cubs will be his offspring. A litter of 2-6 cubs are born. Usually, only 1-2 cubs survive until introduced to the pride, at which point they are protected by the whole pride."));
        Collections.shuffle(animallist);
        Collections.shuffle(animallist);
        Collections.shuffle(animallist);
    }

}
