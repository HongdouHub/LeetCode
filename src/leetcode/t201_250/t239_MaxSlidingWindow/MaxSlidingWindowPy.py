# -*- coding: utf-8 -*-

class MaxSlidingWindowPy(object):

    def maxSlidingWindow(nums, k):
        if not nums: return []
        window, res = [], []
        for i, x in enumerate(nums):
            if i>= k and window[0] <= i - k:
                window.pop(0)
            while window and nums[window[-1]] <= x:
                window.pop()
            window.append(i)
            if i >= k - 1:
                res.append(nums[window[0]])
        return res

    if __name__ == '__main__':
        nums = [1,3,1,2,0,5]
        k = 3
        maxSlidingWindow(nums, k)