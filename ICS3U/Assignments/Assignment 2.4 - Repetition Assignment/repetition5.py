initialCannonballCount = 10000
cannonballCount = initialCannonballCount
layer = 1
while True:
    if cannonballCount - layer**2 >= 0:
        cannonballCount -= layer**2
        layer += 1
    else:
        layer -= 1
        break

print(f"From {initialCannonballCount} cannonballs, you can make a pyramid with {layer} layers. You would end up with {cannonballCount} cannonballs left over.")