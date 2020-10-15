# -*- coding: utf-8 -*-
from sys import maxint


class CommMethodPy(object):

    # 最多进行一次买卖操作
    def maxProfit(prices):
        if not prices: return 0

        res = 0

        # max_profit[i][j]
        # i : 数组长度为 i
        # j : 0表示 没有买入股票的时候；
        #     1表示 买入了一股股票的时候；
        #     2表示 之前买入股票，现在将它卖出的时候
        profit = [[0 for i in xrange(3)] for i in xrange(len(prices))]

        profit[0][0], profit[0][1], profit[0][2] = 0, -prices[0], 0

        for i in range(1, len(prices)):
            profit[i][0] = profit[i - 1][0]
            profit[i][1] = max(profit[i - 1][1], profit[i - 1][0] - prices[i])
            profit[i][2] = profit[i - 1][1] + prices[i]
            res = max(res, profit[i][0], profit[i][1], profit[i][2])

        return res

    def maxProfit2(prices):
        if not prices: return 0

        # max_profit[i][j][k]
        # i : 数组长度为 i
        # j : 当前交易了 j 次（买入和卖出）
        # k : 当前是否持有股票（0：没有股票； 1：持有股票）
        profit = [[[0 for _ in xrange(2)] for _ in range(3)] for _ in xrange(len(prices))]

        profit[0][0][0], profit[0][0][1] = 0, -prices[0]
        profit[0][1][0], profit[0][1][1] = -maxint, -maxint
        profit[0][2][0], profit[0][2][1] = -maxint, -maxint

        for i in range(1, len(prices)):
            profit[i][0][0] = profit[i - 1][0][0]
            profit[i][0][1] = max(profit[i - 1][0][1], profit[i - 1][0][0] - prices[i])

            profit[i][1][0] = max(profit[i - 1][1][0], profit[i - 1][0][1] + prices[i])
            profit[i][1][1] = max(profit[i - 1][1][1], profit[i - 1][1][0] - prices[i])

            profit[i][2][0] = max(profit[i - 1][2][0], profit[i - 1][1][1] + prices[i])

        end = len(prices) - 1
        return max(profit[end][0][0], profit[end][1][0], profit[end][2][0])

    if __name__ == '__main__':
        prices = [7, 1, 5, 3, 6, 4]
        print (maxProfit(prices))
        print (maxProfit2(prices))
