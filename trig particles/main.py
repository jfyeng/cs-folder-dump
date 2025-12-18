import pygame, sys, math, random

# USAGE CONSTANTS
WINDOW_SIZE = (800,800)

BURST_COUNT = 5 # how many particles to burst when clicked
PARTICLE_SIZE_RANGE = (5,15) # randomly select particle size in given range
SPEED_RANGE = (1,100) # randomly selects a speed in the given range
SPEED_DIVISOR = 100 # divides the speed by this, useful for slower particles
PARTICLE_OPACITY_DECREASE = 3 # how quickly a particle fades away, higher = shorter lifespan
PARTICLE_LIFESPAN = -1 # how long particles can live, in frames. set to -1 to disable.
PARTICLE_COLOR = (80, 180, 235) # set this to "random" for random, otherwise use a color like this: (0,0,0)
SPAWN_INTERVAL = 0 # interval of spawn in ticks
SAFE_ZONE = (0 - PARTICLE_SIZE_RANGE[1], WINDOW_SIZE[0] + PARTICLE_SIZE_RANGE[1]) # if the particles leave this area they DIE
BACKGROUND_COLOR = (220,245,255)

pygame.init()
pygame.display.set_caption("Trigonometry Particles")
display = pygame.display.set_mode(WINDOW_SIZE)
clock = pygame.time.Clock()

class Particle:
    def __init__(self, x, y, speed, angle, size, color):
        self.surf = pygame.Surface((size,size))
        self.color = color
        self.surf.fill(self.color)
        self.opacity = 255
        self.x, self.y = x, y
        self.px, self.py = int(self.x), int(self.y)
        self.size = size
        self.speed = speed / SPEED_DIVISOR
        self.angle = angle
        self.age = 0

    def update(self):
        self.age += 1

        self.x += math.cos(self.angle) * self.speed
        self.y += math.sin(self.angle) * self.speed
        self.px, self.py = int(self.x), int(self.y)

        if not SAFE_ZONE[0] <= self.x <= SAFE_ZONE[1] or not SAFE_ZONE[0] <= self.y <= SAFE_ZONE[1] or self.opacity == 0 or self.age >= PARTICLE_LIFESPAN and PARTICLE_LIFESPAN != -1:
            return "done"

        self.opacity -= PARTICLE_OPACITY_DECREASE
        self.surf.set_alpha(self.opacity)

    def render(self, surf):
        surf.blit(self.surf, (self.px, self.py))

particles = []
clicking = False
last_spawn = 0
while True:
    display.fill(BACKGROUND_COLOR)

    for particle in particles:
        if particle.update() == "done":
            particles.remove(particle)

        particle.render(display)

    if clicking:
        now = pygame.time.get_ticks()
        if now - last_spawn >= SPAWN_INTERVAL:
            mouse_pos = pygame.mouse.get_pos()
            for i in range(BURST_COUNT):
                particles.append(Particle(mouse_pos[0], mouse_pos[1], random.randint(SPEED_RANGE[0],SPEED_RANGE[1]), random.randint(0,360), random.randint(PARTICLE_SIZE_RANGE[0],PARTICLE_SIZE_RANGE[1]), (random.randint(0,255), random.randint(0,255), random.randint(0,255)) if PARTICLE_COLOR == "random" else PARTICLE_COLOR)) # x, y, speed, angle, size, color
            last_spawn = now

    for event in pygame.event.get():
        if event.type == pygame.MOUSEBUTTONDOWN:
            if event.button == 1:
                clicking = True
        if event.type == pygame.MOUSEBUTTONUP:
            if event.button == 1:
                clicking = False
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    pygame.display.flip()
    clock.tick(60)
