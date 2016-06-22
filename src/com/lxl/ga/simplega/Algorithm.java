package com.lxl.ga.simplega;

/**
 * 遗传算法实现类
 *
 * @author lixiaolin
 * @createDate 2016-06-22 16:16
 */
public class Algorithm {
    // 交叉概率
    private static final double uniformRate = 0.5;
    // 突变概率
    private static final double mutationRate = 0.015;
    // 淘汰数组的大小
    private static final int tournamentSize = 5;
    // 精英主义
    private static final boolean elitism = true;

    /**
     * 进化一个种群
     *
     * @param pop 原始种群
     * @return 进化后的种群
     */
    public static Population evolvePopulation(Population pop) {
        // 存放新一代的种群
        Population newPopulation = new Population(pop.size(), false);

        // 精英主义策略
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }

        // 种群交叉
        for (int i = elitismOffset; i < pop.size(); i++) {
            // 随机选择两个优秀的个体
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            // 进行交叉
            Individual newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // 种群突变
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    /**
     * 两个个体交叉产生下一代
     * @param indiv1 父亲
     * @param indiv2 母亲
     * @return 后代
     */
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        // 随机的从两个个体中选择
        for (int i = 0; i < indiv1.size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    /**
     * 突变个体。突变的概率为 mutationRate
     * @param indiv 待突变的个体
     */
    private static void mutate(Individual indiv) {
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // 生成随机的 0 或 1
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    /**
     * 随机选择一个较优秀的个体。用于进行交叉
     * @param pop 种群
     * @return
     */
    private static Individual tournamentSelection(Population pop) {
        Population tournamentPop = new Population(tournamentSize, false);
        // 随机选择 tournamentSize 个放入 tournamentPop 中
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournamentPop.saveIndividual(i, pop.getIndividual(randomId));
        }
        // 找到淘汰数组中最优秀的
        Individual fittest = tournamentPop.getFittest();
        return fittest;
    }
}